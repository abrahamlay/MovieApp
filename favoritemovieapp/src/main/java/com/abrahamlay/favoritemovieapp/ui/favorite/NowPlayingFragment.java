package com.abrahamlay.favoritemovieapp.ui.favorite;

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
