package com.abrahamlay.movieapp.ui.tab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abrahamlay.movieapp.R;
import com.abrahamlay.movieapp.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public abstract class TabFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager pager;

    private TabAdapter adapter;
    protected List<Fragment> fragments;
    protected List<String> titles;

    protected abstract void initFragmentAndTitle();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab,container,false);
        tabLayout=view.findViewById(R.id.tab);
        pager=view.findViewById(R.id.pager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragments= new ArrayList<>();
        titles= new ArrayList<>();

        initFragmentAndTitle();
        initTabAndPager();
    }

    private void initTabAndPager() {
        if(isAdded()){
            adapter=new TabAdapter(fragments,titles,getChildFragmentManager());
            pager.setAdapter(adapter);
            tabLayout.setupWithViewPager(pager);
            pager.setOffscreenPageLimit(fragments.size());
        }
    }

}
