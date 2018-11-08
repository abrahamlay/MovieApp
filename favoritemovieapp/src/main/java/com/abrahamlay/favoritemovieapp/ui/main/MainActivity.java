package com.abrahamlay.favoritemovieapp.ui.main;

import android.os.Bundle;

import com.abrahamlay.favoritemovieapp.R;
import com.abrahamlay.favoritemovieapp.ui.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new (),false);
    }
}
