package com.abrahamlay.movieapp.ui;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.abrahamlay.movieapp.util.app.MyApplication;

public abstract class BaseFragment extends Fragment {
    public Context getApplicationContext() {
        if (getActivity() == null) return MyApplication.getInstance().getApplicationContext();
        return getActivity().getApplicationContext();
    }

}
