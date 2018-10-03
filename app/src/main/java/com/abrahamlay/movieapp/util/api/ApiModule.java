package com.abrahamlay.movieapp.util.api;

import com.abrahamlay.movieapp.repository.movie.MovieService;
import com.abrahamlay.movieapp.repository.search.SearchService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abrahamlay on 15/08/2018.
 */
@Module
public class ApiModule {

    @Provides
    String provideBaseUrl() {
        return ApiConfig.BASE_URL;
    }

    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create(ApiConfig.GSON);
    }

    @Provides
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory(){
        return ApiConfig.rxAdapter;
    }

    @Provides
    public Retrofit provideAPI(String baseURL
            , GsonConverterFactory converterFactory
            , RxJava2CallAdapterFactory rxAdapter
                               ){
        return new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(rxAdapter)
                    .build();
    }

    @Provides
    public SearchService provideSearchService(Retrofit retrofit){
        return retrofit.create(SearchService.class);
    }

    @Provides
    public MovieService provideMovieService(Retrofit retrofit){
        return retrofit.create(MovieService.class);
    }
}
