package com.abrahamlay.movieapp.repository.movie;

import com.abrahamlay.movieapp.model.movie.MovieResult;
import com.abrahamlay.movieapp.ui.BaseView;
import com.abrahamlay.movieapp.util.api.ApiConfig;
import com.abrahamlay.movieapp.util.api.CallbackWrapper;
import com.abrahamlay.movieapp.util.api.RemoteCallback;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieDataSource implements MovieRepositoryContract {

    private final CompositeDisposable compositeDisposable;
    private MovieService service;

    public MovieDataSource(MovieService service) {
        this.service = service;
        compositeDisposable=new CompositeDisposable();
    }

    @Override
    public void getUpcoming(BaseView view, final RemoteCallback<MovieResult> callback) {

        Disposable disposable=service.loadUpcomingMovie(ApiConfig.API_KEY
                ,ApiConfig.LANG_SETTINGS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CallbackWrapper<MovieResult>(view) {
                    @Override
                    protected void onSuccess(MovieResult movieResult) {
                        callback.onDataLoaded(movieResult);
                    }
                });

        compositeDisposable.add(disposable);
    }

    @Override
    public void getNowPlaying(BaseView view, final RemoteCallback<MovieResult> callback) {
        Disposable disposable=service.loadNowPlayingMovie(ApiConfig.API_KEY
                ,ApiConfig.LANG_SETTINGS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CallbackWrapper<MovieResult>(view) {
                    @Override
                    protected void onSuccess(MovieResult movieResult) {
                        callback.onDataLoaded(movieResult);
                    }
                });

        compositeDisposable.add(disposable);
    }
}
