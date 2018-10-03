package com.abrahamlay.movieapp.repository;

import com.abrahamlay.movieapp.repository.movie.MovieDataSource;
import com.abrahamlay.movieapp.repository.movie.MovieRepository;
import com.abrahamlay.movieapp.repository.movie.MovieService;
import com.abrahamlay.movieapp.repository.search.SearchDataSource;
import com.abrahamlay.movieapp.repository.search.SearchRepository;
import com.abrahamlay.movieapp.repository.search.SearchService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abrahamlay on 15/08/2018.
 */

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    SearchDataSource provideSearchDataSource(SearchService service){
        return new SearchDataSource(service);
    }

    @Provides
    @Singleton
    SearchRepository provideSearchRepository(SearchDataSource dataSource){
        return new SearchRepository(dataSource);
    }

    @Provides
    @Singleton
    MovieDataSource provideMovieDataSource(MovieService service){
        return new MovieDataSource(service);
    }

    @Provides
    @Singleton
    MovieRepository provideMovieRepository(MovieDataSource dataSource){
        return new MovieRepository(dataSource);
    }

}
