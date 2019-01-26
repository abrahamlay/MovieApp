package com.abrahamlay.movieapp.ui.favorite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.abrahamlay.movieapp.db.MovieHelper;
import com.abrahamlay.movieapp.model.movie.ResultsItem;
import com.abrahamlay.movieapp.ui.BaseListFragment;
import com.abrahamlay.movieapp.ui.Const;
import com.abrahamlay.movieapp.ui.OnItemClickListener;
import com.abrahamlay.movieapp.ui.adapter.MovieAdapter;
import com.abrahamlay.movieapp.ui.detail.DetailActivity;
import com.abrahamlay.movieapp.util.app.Injector;

import java.util.List;

import javax.inject.Inject;

public abstract class FavoriteMovieFragment extends BaseListFragment<FavoriteMoviePresenter> implements FavoriteMovieContract.MovieView,
        OnItemClickListener {
    @Inject
    MovieHelper movieHelper;
    FavoriteMoviePresenter presenter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Injector.obtain(getActivity()).inject(this);

        presenter=new FavoriteMoviePresenter(this, movieHelper);
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
    public void setPresenter(FavoriteMoviePresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void onMovieLoaded(List<ResultsItem> movieResult) {
        mItemList=movieResult;
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
