package com.abrahamlay.movieapp.repository.movie;

import com.abrahamlay.movieapp.model.movie.MovieResult;
import com.abrahamlay.movieapp.ui.BaseView;
import com.abrahamlay.movieapp.util.api.RemoteCallback;

interface MovieRepositoryContract {
    void getUpcoming(BaseView view, RemoteCallback<MovieResult> callback);
    void getNowPlaying(BaseView view, RemoteCallback<MovieResult> callback);
}
