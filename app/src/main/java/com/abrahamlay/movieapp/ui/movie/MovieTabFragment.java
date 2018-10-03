package com.abrahamlay.movieapp.ui.movie;

import com.abrahamlay.movieapp.R;
import com.abrahamlay.movieapp.ui.tab.TabFragment;



public class MovieTabFragment extends TabFragment {

    @Override
    public void initFragmentAndTitle() {

        titles.add(getString(R.string.now_playing));
        titles.add(getString(R.string.upcoming));
        fragments.add(new NowPlayingFragment());
        fragments.add(new UpcomingFragment());
    }
}
