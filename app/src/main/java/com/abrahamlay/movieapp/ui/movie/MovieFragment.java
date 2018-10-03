package com.abrahamlay.movieapp.ui.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.abrahamlay.movieapp.model.movie.MovieResult;
import com.abrahamlay.movieapp.model.movie.ResultsItem;
import com.abrahamlay.movieapp.repository.movie.MovieRepository;
import com.abrahamlay.movieapp.ui.BaseListFragment;
import com.abrahamlay.movieapp.ui.Const;
import com.abrahamlay.movieapp.ui.OnItemClickListener;
import com.abrahamlay.movieapp.ui.adapter.MovieAdapter;
import com.abrahamlay.movieapp.ui.detail.DetailActivity;
import com.abrahamlay.movieapp.util.app.Injector;

import javax.inject.Inject;

public abstract class MovieFragment extends BaseListFragment<MoviePresenter> implements MovieContract.MovieView,
        OnItemClickListener {
    @Inject
    private
    MovieRepository repository;
    MoviePresenter presenter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Injector.obtain(getActivity()).inject(this);

        presenter=new MoviePresenter(this,repository);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }


    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }


    @Override
    public void setPresenter(MoviePresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void onMovieLoaded(MovieResult movieResult) {
        mItemList=movieResult.getResults();
        adapter= new MovieAdapter(mItemList,this);
        rvList.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(Object data) {
        ResultsItem item= (ResultsItem)data;
        startActivity(new Intent(getActivity(), DetailActivity.class)
                .putExtra(Const.PARAM_RESULT_ITEM,item));
    }

}
