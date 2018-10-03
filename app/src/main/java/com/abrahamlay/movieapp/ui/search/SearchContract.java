package com.abrahamlay.movieapp.ui.search;

import com.abrahamlay.movieapp.model.search.SearchResult;
import com.abrahamlay.movieapp.ui.BaseView;

/**
 * Created by abrahamlay on 16/08/2018.
 */

class SearchContract {
    interface SearchView extends BaseView<SearchPresenter> {
        void onResultLoaded(SearchResult data);
    }

    interface SearchAction {
        void findUsers(String query);
        void findUsers(String query, int page);
    }
}
