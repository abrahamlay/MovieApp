package com.abrahamlay.movieapp.util.app;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abrahamlay on 15/08/2018.
 */

@Module
public class MyAppModule {
    private final MyApplication application;

    public MyAppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }

    @Provides
    Context provideContext(){
        return application;
    }

}
