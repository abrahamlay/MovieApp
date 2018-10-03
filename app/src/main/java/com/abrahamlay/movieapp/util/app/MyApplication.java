package com.abrahamlay.movieapp.util.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by abrahamlay on 15/08/2018.
 */

public class MyApplication extends Application {

    private MyAppGraph appGraph;
    private static MyApplication instance;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();

        instance=this;

        // Dagger
        appGraph = Injector.create(this);
        appGraph.inject(this);

    }

    public boolean isInternetAvailable(){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    MyAppGraph getInjector() {
        return appGraph;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
