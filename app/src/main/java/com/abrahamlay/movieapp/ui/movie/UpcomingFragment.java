package com.abrahamlay.movieapp.ui.movie;

import android.content.Context;

import com.abrahamlay.movieapp.ui.movie.MovieFragment;
import com.abrahamlay.movieapp.util.app.Injector;
import com.abrahamlay.movieapp.util.app.MyApplication;

public class UpcomingFragment extends MovieFragment {

    @Override
    protected void loadData() {
        if(MyApplication.get(getContext()).isInternetAvailable()) {
            if(pageToLoad==1){
                presenter.loadUpcomingMovie();
            }else{
                presenter.loadUpcomingMovie();
            }
        }else{
            onNetworkError();
        }
    }

    @Override
    protected boolean isEndlessScrolling() {
        return false;
    }
}
