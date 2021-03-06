package com.abrahamlay.movieapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.abrahamlay.movieapp.R;
import com.abrahamlay.movieapp.ui.BaseActivity;
import com.abrahamlay.movieapp.ui.movie.MovieTabFragment;
import com.abrahamlay.movieapp.ui.search.SearchActivity;
import com.abrahamlay.movieapp.util.DialogComposer;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new MovieTabFragment(),false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_language:
                languageAction();
                break;
            case R.id.action_search:
                searchAction();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void languageAction() {
        DialogComposer.showLanguageChangeDialog(this);
    }

    private void searchAction() {
        startActivity(new Intent(this,SearchActivity.class));
    }
}
