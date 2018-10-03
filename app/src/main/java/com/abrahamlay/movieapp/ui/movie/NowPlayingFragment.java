package com.abrahamlay.movieapp.ui.movie;

import com.abrahamlay.movieapp.ui.movie.MovieFragment;
import com.abrahamlay.movieapp.util.app.MyApplication;

public class NowPlayingFragment extends MovieFragment {

    @Override
    protected void loadData() {
        if(MyApplication.get(getContext()).isInternetAvailable()) {
            if(pageToLoad==1){
                presenter.loadNowPlayingMovie();
            }else{
                presenter.loadNowPlayingMovie();
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
