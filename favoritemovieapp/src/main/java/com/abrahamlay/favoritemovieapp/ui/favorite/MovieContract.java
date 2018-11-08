package com.abrahamlay.favoritemovieapp.ui.favorite;

import com.abrahamlay.favoritemovieapp.model.movie.MovieResult;
import com.abrahamlay.favoritemovieapp.ui.BaseView;


class MovieContract {

   public interface MovieView extends BaseView<MoviePresenter>{
        void onMovieLoaded(MovieResult movieResult);
    }

    public interface MovieAction{
        void loadUpcomingMovie();

        void loadNowPlayingMovie();
    }


}
