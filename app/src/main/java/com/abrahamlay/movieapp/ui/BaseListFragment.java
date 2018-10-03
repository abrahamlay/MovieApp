package com.abrahamlay.movieapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.abrahamlay.movieapp.R;
import com.abrahamlay.movieapp.model.movie.ResultsItem;
import com.abrahamlay.movieapp.ui.search.SearchPresenter;
import com.abrahamlay.movieapp.ui.widget.EmptyViewHolder;
import com.abrahamlay.movieapp.util.api.ApiConfig;

import java.net.HttpURLConnection;
import java.util.List;


/**
 * Created by abrahamlay on 17/08/2018.
 */

public abstract class BaseListFragment<T> extends BaseFragment implements BaseView<T> {


    protected RecyclerView.Adapter adapter;

    protected List<ResultsItem> mItemList;

    protected ProgressBar progressBar;
    protected int pageToLoad = 1;

    protected EmptyViewHolder emptyViewHolder;
    protected RecyclerView rvList;

    protected abstract void loadData();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract boolean isEndlessScrolling();

    public void initState() {
        pageToLoad = 1;
        adapter = null;
        emptyViewHolder.hide();
        rvList.setLayoutManager(getLayoutManager());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        rvList = view.findViewById(R.id.rv_list);
        progressBar = view.findViewById(R.id.progress_bar);
        View emptyView = view.findViewById(R.id.empty_view);

        emptyViewHolder = new EmptyViewHolder(emptyView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initState();

    }


    @Override
    public void showProgressBar(boolean active) {
        progressBar.setVisibility(active ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showEmpty(String message) {
        if (isAdded()) {
            setEmptyRvList();
            emptyViewHolder.setMessage(message == null ? getString(R.string.movie_cant_be_found) : message);
        }
    }

    protected void setEmptyRvList() {
        rvList.setVisibility(View.GONE);
        emptyViewHolder.show();
    }


    @Override
    public void onUnknownError(int code, String errorMessage) {
        if (isAdded()) {
            if (pageToLoad == 1) {
                setEmptyRvList();

                if (code == HttpURLConnection.HTTP_FORBIDDEN) {
                    emptyViewHolder.setMessage(getString(R.string.error_limit_request));
                    return;
                }
                if (code == ApiConfig.HTTP_UNPROCESSABLE_ENTITY) {
                    emptyViewHolder.setMessage(getString(R.string.error_empty_query));
                    return;
                }
                emptyViewHolder.setMessage(errorMessage);
            } else {
//                ((MovieAdapter) adapter).setMoreDataAvailable(false);
                adapter.notifyDataSetChanged();
                if (code == HttpURLConnection.HTTP_FORBIDDEN) {
                    Toast.makeText(getContext(), R.string.error_limit_request, Toast.LENGTH_LONG).show();
                    return;
                }
                if (code == ApiConfig.HTTP_UNPROCESSABLE_ENTITY) {
                    Toast.makeText(getContext(), R.string.error_empty_query, Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onTimeout() {
        if (isAdded()) {
            if (pageToLoad == 1) {
                setEmptyRvList();
                emptyViewHolder.showOnTimeout();
            } else {
//                ((MovieAdapter) adapter).setMoreDataAvailable(false);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), R.string.timeout_error, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onNetworkError() {
        if (isAdded()) {
            if (pageToLoad == 1) {
                setEmptyRvList();
                emptyViewHolder.showOnNetworkError();
            } else {
//                ((MovieAdapter)adapter).setMoreDataAvailable(false);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), R.string.network_error, Toast.LENGTH_LONG).show();
            }
        }
    }

}
