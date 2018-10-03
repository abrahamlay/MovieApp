package com.abrahamlay.movieapp.ui.search;

import com.abrahamlay.movieapp.model.search.SearchResult;
import com.abrahamlay.movieapp.repository.search.SearchRepository;
import com.abrahamlay.movieapp.util.api.RemoteCallback;

/**
 * Created by abrahamlay on 16/08/2018.
 */

public class SearchPresenter implements SearchContract.SearchAction {
    private final SearchContract.SearchView view;
    private final SearchRepository repository;

    public SearchPresenter(SearchContract.SearchView view, SearchRepository repository) {
        this.view = view;
        this.repository = repository;
        this.view.setPresenter(this);
    }

    @Override
    public void findUsers(String query) {
        view.showProgressBar(true);
        repository.findUser(query, 1, view,new RemoteCallback<SearchResult>() {
            @Override
            public void onDataLoaded(SearchResult data) {

                if (data.getResults().size()==0){
                    view.showProgressBar(false);
                    view.showEmpty(null);
                    return;
                }

                view.showProgressBar(false);
                view.onResultLoaded(data);
            }
        });
    }

    @Override
    public void findUsers(String query, int page) {
        repository.findUser(query, page,view, new RemoteCallback<SearchResult>() {
            @Override
            public void onDataLoaded(SearchResult data) {
                view.onResultLoaded(data);
            }
        });
    }
}
