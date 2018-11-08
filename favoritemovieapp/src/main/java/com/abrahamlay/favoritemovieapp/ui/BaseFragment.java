package com.abrahamlay.favoritemovieapp.ui;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.abrahamlay.favoritemovieapp.util.app.MyApplication;

public abstract class BaseFragment extends Fragment {
    public Context getApplicationContext() {
        if (getActivity() == null) return MyApplication.getInstance().getApplicationContext();
        return getActivity().getApplicationContext();
    }

}
