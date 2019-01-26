package com.abrahamlay.favoritemovieapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ProgressBar;

import com.abrahamlay.favoritemovieapp.R;
import com.abrahamlay.favoritemovieapp.model.movie.ResultsItem;
import com.abrahamlay.favoritemovieapp.ui.widget.CursorRecyclerViewAdapter;
import com.abrahamlay.favoritemovieapp.ui.widget.EmptyViewHolder;

import java.util.List;


/**
 * Created by abrahamlay on 17/08/2018.
 */

public abstract class BaseListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    protected CursorRecyclerViewAdapter adapter;

    protected List<ResultsItem> mItemList;

    private ProgressBar progressBar;
    protected int pageToLoad = 1;

    private EmptyViewHolder emptyViewHolder;
    protected RecyclerView rvList;
    private SwipeRefreshLayout swipeRefresh;

    protected abstract void loadData();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract boolean isEndlessScrolling();

    @Override
    public void onRefresh() {
        initState();
        loadData();
    }

    protected void initState() {
        pageToLoad = 1;
        adapter = null;
        emptyViewHolder.hide();
        rvList.setLayoutManager(getLayoutManager());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        swipeRefresh=view.findViewById(R.id.refresh);
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
        swipeRefresh.setOnRefreshListener(this);
        swipeRefresh.setEnabled(false);

    }

    private void setEmptyRvList() {
        rvList.setVisibility(View.GONE);
        emptyViewHolder.show();
    }

}
