package com.abrahamlay.movieapp.repository.search;

import com.abrahamlay.movieapp.model.search.SearchResult;
import com.abrahamlay.movieapp.ui.BaseView;
import com.abrahamlay.movieapp.util.api.RemoteCallback;

/**
 * Created by abrahamlay on 15/08/2018.
 */

interface SearchRepositoryContract {
    void findUser(String query, int page, BaseView view, RemoteCallback<SearchResult> callback);
}
