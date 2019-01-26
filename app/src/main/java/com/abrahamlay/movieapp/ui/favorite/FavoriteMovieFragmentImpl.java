package com.abrahamlay.movieapp.ui.favorite;

public class FavoriteMovieFragmentImpl extends FavoriteMovieFragment {

    @Override
    protected void loadData() {
        presenter.loadMoviefromDb();
    }

    @Override
    protected boolean isEndlessScrolling() {
        return false;
    }
}
