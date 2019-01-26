package com.abrahamlay.favoritemovieapp.util.app;



import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abrahamlay on 15/08/2018.
 */

@Component(
        modules = {
                MyAppModule.class
        }
)

@Singleton
public interface MyAppComponent extends MyAppGraph {
}
