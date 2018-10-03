package com.abrahamlay.movieapp.util.api;

/**
 * Created by abrahamlay on 15/08/2018.
 */

public interface RemoteCallback<T> {
        void onDataLoaded(T data);
}
