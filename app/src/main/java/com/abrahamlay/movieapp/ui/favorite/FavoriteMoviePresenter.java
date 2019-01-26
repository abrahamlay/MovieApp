package com.abrahamlay.movieapp.ui.favorite;

import com.abrahamlay.movieapp.db.MovieHelper;
import com.abrahamlay.movieapp.model.movie.ResultsItem;

import java.util.List;

public class FavoriteMoviePresenter implements FavoriteMovieContract.MovieAction {

    private final FavoriteMovieContract.MovieView view;
    private final MovieHelper movieHelper;

    public FavoriteMoviePresenter(FavoriteMovieContract.MovieView view, MovieHelper movieHelper) {
        this.view = view;
        this.movieHelper = movieHelper;
    }

    @Override
    public void loadMoviefromDb() {
        view.showProgressBar(true);
        movieHelper.open();
        List<ResultsItem> items=movieHelper.query();
        if (items==null||items.size()==0){
            view.showEmpty("Oops, we cannot find your favorite movie");
            view.showProgressBar(false);
        }else{
            view.onMovieLoaded(items);
            view.showProgressBar(false);
        }
        movieHelper.close();

    }
}
