package com.abrahamlay.movieapp.util.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by abrahamlay on 15/08/2018.
 */

public class ApiConfig {
    public static final Gson GSON = new GsonBuilder()
            .create();
    public static final String BASE_URL="https://api.themoviedb.org/3/";
    public static final String API_KEY="e1364e3bc8f9d46c4a09586973081f96";
    public static final String LANG_SETTINGS="en-US";
    public static final String SEARCH_PATH="search/movie?";
    public static final String NOW_PLAYING_PATH="movie/now_playing?";
    public static final String UPCOMING_PATH="movie/upcoming?";

    public static final int NETWORK_TIMEOUT=40;

    public static final RxJava2CallAdapterFactory rxAdapter=RxJava2CallAdapterFactory.create();

    public static final int HTTP_UNPROCESSABLE_ENTITY = 422;
}
