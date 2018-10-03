package com.abrahamlay.movieapp.util.app;


import com.abrahamlay.movieapp.ui.movie.MovieFragment;
import com.abrahamlay.movieapp.ui.movie.UpcomingFragment;
import com.abrahamlay.movieapp.ui.search.SearchFragment;
import com.abrahamlay.movieapp.ui.movie.NowPlayingFragment;

/**
 * Created by abrahamlay on 15/08/2018.
 */

public interface MyAppGraph {

    void inject(MyApplication myApplication);

    void inject(SearchFragment searchFragment);
    void inject(MovieFragment movieFragment);
    void inject(NowPlayingFragment movieFragment);
    void inject(UpcomingFragment movieFragment);

}
