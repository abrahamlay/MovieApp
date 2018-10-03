package com.abrahamlay.movieapp.repository.movie;

import com.abrahamlay.movieapp.model.movie.MovieResult;
import com.abrahamlay.movieapp.ui.BaseView;
import com.abrahamlay.movieapp.util.api.RemoteCallback;

public class MovieRepository implements MovieRepositoryContract {

    private final MovieDataSource movieDataSource;

    public MovieRepository(MovieDataSource movieDataSource) {
        this.movieDataSource = movieDataSource;
    }

    @Override
    public void getUpcoming(BaseView view, RemoteCallback<MovieResult> callback) {
        movieDataSource.getUpcoming(view,callback);
    }

    @Override
    public void getNowPlaying(BaseView view, RemoteCallback<MovieResult> callback) {
        movieDataSource.getNowPlaying(view,callback);
    }
}
