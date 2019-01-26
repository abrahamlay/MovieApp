package com.abrahamlay.movieapp.ui.favorite;

import com.abrahamlay.movieapp.model.movie.ResultsItem;
import com.abrahamlay.movieapp.ui.BaseView;

import java.util.List;


class FavoriteMovieContract {

   public interface MovieView extends BaseView<FavoriteMoviePresenter>{
       void onMovieLoaded(List<ResultsItem> movieResult);
   }

   public interface MovieAction{
       void loadMoviefromDb();
   }


}
