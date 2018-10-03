package com.abrahamlay.movieapp.ui.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> items;
    private final List<String> titles;

    public TabAdapter(List<Fragment> items, List<String> titles, FragmentManager childFragmentManager) {
        super(childFragmentManager);
        this.items=items;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}
