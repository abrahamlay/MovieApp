package com.abrahamlay.favoritemovieapp.util.api;


import com.abrahamlay.movieapp.ui.BaseView;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

/**
 * Created by hrskrs on 3/20/2017.
 *
 * DisposableObserver wrapper for handling errors on a single place
 *
 * https://github.com/hrskrs/Use-Case/blob/master/app/src/main/java/com/hrskrs/stealthymvp/data/remote/CallbackWrapper.java
 */
public abstract class CallbackWrapper<T> extends DisposableObserver<T> {

    private final BaseView view;

    public CallbackWrapper(BaseView view) {
        this.view = view;
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        int code=0;
        if (t instanceof HttpException) {

            ResponseBody responseBody = ((HttpException) t).response().errorBody();
            code = ((HttpException) t).response().code();
            view.showProgressBar(false);
            view.onUnknownError(code,getErrorMessage(responseBody));
        } else if (t instanceof SocketTimeoutException) {
            view.showProgressBar(false);
            view.onTimeout();
        } else if (t instanceof IOException) {
            view.showProgressBar(false);
            view.onNetworkError();
        } else {
            view.showProgressBar(false);
            view.onUnknownError(code, t.getMessage());
        }
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(T t);

    private String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("message");
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}