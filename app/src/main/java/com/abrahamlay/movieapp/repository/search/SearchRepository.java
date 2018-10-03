package com.abrahamlay.movieapp.repository.search;

import com.abrahamlay.movieapp.model.search.SearchResult;
import com.abrahamlay.movieapp.ui.BaseView;
import com.abrahamlay.movieapp.util.api.RemoteCallback;

/**
 * Created by abrahamlay on 15/08/2018.
 */

public class SearchRepository implements SearchRepositoryContract {

    private final SearchDataSource dataSource;

    public SearchRepository(SearchDataSource dataSource) {
        this.dataSource=dataSource;
    }


    @Override
    public void findUser(String query, int page, BaseView view, final RemoteCallback<SearchResult> callback) {
        dataSource.findUser(query, page, view,callback);
    }
}
