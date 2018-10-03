package com.abrahamlay.movieapp.repository.movie;

import com.abrahamlay.movieapp.model.movie.MovieResult;
import com.abrahamlay.movieapp.util.api.ApiConfig;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET(ApiConfig.UPCOMING_PATH)
    Observable<MovieResult> loadUpcomingMovie(@Query("api_key") String apiKey
            , @Query("language") String lang);

    @GET(ApiConfig.NOW_PLAYING_PATH)
    Observable<MovieResult> loadNowPlayingMovie(@Query("api_key") String apiKey
            , @Query("language") String lang);
}
