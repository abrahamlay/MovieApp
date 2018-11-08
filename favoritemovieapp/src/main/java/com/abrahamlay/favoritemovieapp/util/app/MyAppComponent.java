package com.abrahamlay.favoritemovieapp.util.app;

import com.abrahamlay.movieapp.repository.RepositoryModule;
import com.abrahamlay.movieapp.util.api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abrahamlay on 15/08/2018.
 */

@Component(
        modules = {
                MyAppModule.class,
                ApiModule.class,
                RepositoryModule.class
        }
)

@Singleton
public interface MyAppComponent extends MyAppGraph {
}
