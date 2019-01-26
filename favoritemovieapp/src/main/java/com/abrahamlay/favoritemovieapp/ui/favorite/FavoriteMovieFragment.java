package com.abrahamlay.favoritemovieapp.ui.favorite;

import android.support.v4.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.CursorLoader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.abrahamlay.favoritemovieapp.ui.BaseListFragment;
import com.abrahamlay.favoritemovieapp.ui.OnItemClickListener;
import com.abrahamlay.favoritemovieapp.ui.adapter.MovieAdapter;
import com.abrahamlay.favoritemovieapp.ui.adapter.MovieCursorAdapter;
import com.abrahamlay.favoritemovieapp.ui.detail.DetailActivity;

import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.MovieColumns.CONTENT_URI;


public class FavoriteMovieFragment extends BaseListFragment implements  LoaderManager.LoaderCallbacks<Cursor>,
        OnItemClickListener {
    private final int LOAD_MOVIE_ID = 110;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }


    @Override
    protected void loadData() {
        adapter= new MovieAdapter(getContext(),null,this);
        rvList.setAdapter(adapter);
        getActivity().getSupportLoaderManager().initLoader(LOAD_MOVIE_ID, null, this);
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    protected boolean isEndlessScrolling() {
        return false;
    }


    @Override
    public void onItemClicked(Object data) {
//        ResultsItem item= (ResultsItem)data;
//        startActivity(new Intent(getActivity(), DetailActivity.class)
//                .putExtra(Const.PARAM_RESULT_ITEM,item));
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().getSupportLoaderManager().restartLoader(LOAD_MOVIE_ID,null,this);
    }

    @NonNull
    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new CursorLoader(getContext(),CONTENT_URI,null,null,null,null);
    }

    @Override
    public void onLoadFinished(@NonNull android.support.v4.content.Loader<Cursor> loader, Cursor cursor) {
        adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(@NonNull android.support.v4.content.Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
