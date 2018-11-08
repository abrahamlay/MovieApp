package com.abrahamlay.favoritemovieapp.ui.favorite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.abrahamlay.favoritemovieapp.model.movie.MovieResult;
import com.abrahamlay.favoritemovieapp.model.movie.ResultsItem;
import com.abrahamlay.favoritemovieapp.ui.BaseListFragment;
import com.abrahamlay.favoritemovieapp.ui.Const;
import com.abrahamlay.favoritemovieapp.ui.OnItemClickListener;
import com.abrahamlay.favoritemovieapp.ui.detail.DetailActivity;
import com.abrahamlay.favoritemovieapp.util.app.Injector;

import javax.inject.Inject;

public abstract class MovieFragment extends BaseListFragment<MoviePresenter> implements MovieContract.MovieView,
        OnItemClickListener {
    @Inject
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
