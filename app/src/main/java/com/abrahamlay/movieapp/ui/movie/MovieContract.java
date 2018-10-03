package com.abrahamlay.movieapp.ui.movie;

import com.abrahamlay.movieapp.model.movie.MovieResult;
import com.abrahamlay.movieapp.ui.BaseView;


public class MovieContract {

   public interface MovieView extends BaseView<MoviePresenter>{
        void onMovieLoaded(MovieResult movieResult);
    }

    public interface MovieAction{
        void loadUpcomingMovie();

        void loadNowPlayingMovie();
    }


}
