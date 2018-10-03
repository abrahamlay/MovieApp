package com.abrahamlay.movieapp.ui;


/**
 * Created by abrahamlay on 16/08/2018.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
    void showProgressBar(boolean active);
    void showEmpty(String message);

    void onUnknownError(int code, String errorMessage);

    void onTimeout();

    void onNetworkError();
}
