package com.abrahamlay.movieapp.ui.movie;

import com.abrahamlay.movieapp.model.movie.MovieResult;
import com.abrahamlay.movieapp.repository.movie.MovieRepository;
import com.abrahamlay.movieapp.util.api.RemoteCallback;

public class MoviePresenter implements MovieContract.MovieAction {

    private MovieContract.MovieView view;
    private MovieRepository movieRepository;

    public MoviePresenter(MovieContract.MovieView view, MovieRepository movieRepository) {
        this.view = view;
        this.movieRepository = movieRepository;
    }

    @Override
    public void loadUpcomingMovie() {
        view.showProgressBar(true);
        movieRepository.getUpcoming(view, new RemoteCallback<MovieResult>() {
            @Override
            public void onDataLoaded(MovieResult data) {
                view.onMovieLoaded(data);
                view.showProgressBar(false);
            }
        });
    }

    @Override
    public void loadNowPlayingMovie() {
        view.showProgressBar(true);
        movieRepository.getNowPlaying(view, new RemoteCallback<MovieResult>() {
            @Override
            public void onDataLoaded(MovieResult data) {
                view.onMovieLoaded(data);
                view.showProgressBar(false);
            }
        });
    }
}
