package com.abrahamlay.movieapp.repository.search;

import com.abrahamlay.movieapp.model.search.SearchResult;
import com.abrahamlay.movieapp.util.api.ApiConfig;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abrahamlay on 15/08/2018.
 */

public interface SearchService {
    @GET(ApiConfig.SEARCH_PATH)
    Observable<SearchResult> searchUsers(@Query("api_key") String apiKey
            , @Query("language") String lang
            , @Query("page") int page
            , @Query("query") String query);
}
