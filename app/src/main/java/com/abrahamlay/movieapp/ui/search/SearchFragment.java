package com.abrahamlay.movieapp.ui.search;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.abrahamlay.movieapp.model.movie.ResultsItem;
import com.abrahamlay.movieapp.model.search.SearchResult;
import com.abrahamlay.movieapp.repository.search.SearchRepository;
import com.abrahamlay.movieapp.ui.BaseListFragment;
import com.abrahamlay.movieapp.ui.Const;
import com.abrahamlay.movieapp.ui.OnItemClickListener;
import com.abrahamlay.movieapp.ui.adapter.MovieAdapter;
import com.abrahamlay.movieapp.ui.detail.DetailActivity;
import com.abrahamlay.movieapp.util.app.Injector;
import com.abrahamlay.movieapp.util.app.MyApplication;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseListFragment<SearchPresenter> implements SearchContract.SearchView,
        OnItemClickListener {
    @Inject
    SearchRepository repository;

    private SearchPresenter presenter;
    private android.support.v7.widget.SearchView searchView;


    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Injector.obtain(getActivity()).inject(this);

        new SearchPresenter(this,repository);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initSearchView();
    }

    private void initSearchView(){
        if( getActivity() instanceof SearchActivity && getActivity()!=null) {
            searchView =((SearchActivity)getActivity()).getSearchView();
        }

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                loadData();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                initState();
                return true;
            }
        });
    }

    @Override
    public void onResultLoaded(SearchResult data) {
        mItemList=data.getResults();
        adapter= new MovieAdapter(mItemList,this);
        rvList.setAdapter(adapter);
    }

    @Override
    public void setPresenter(SearchPresenter presenter) {
        this.presenter=presenter;
    }



    @Override
    public void onItemClicked(View view, Object data, int position) {
        ResultsItem item= (ResultsItem)data;
        startActivity(new Intent(getActivity(), DetailActivity.class)
                .putExtra(Const.PARAM_RESULT_ITEM,item));
    }

    @Override
    protected void loadData() {
        if(MyApplication.get(getContext()).isInternetAvailable()) {
            if(pageToLoad==1){
                presenter.findUsers(searchView.getQuery().toString());
            }else{
                presenter.findUsers(searchView.getQuery().toString(),pageToLoad);
            }
        }else{
            onNetworkError();
        }

    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    protected boolean isEndlessScrolling() {
        return false;
    }

}
