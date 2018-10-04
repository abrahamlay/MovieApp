   package com.abrahamlay.movieapp.ui.search;

import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.abrahamlay.movieapp.R;
import com.abrahamlay.movieapp.ui.BaseActivity;

   public class SearchActivity extends BaseActivity {

      private Toolbar toolbar;
      private SearchView searchView;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_search);

          initToolbar();
          replaceFragment(new SearchFragment(),false);
      }

      private void initToolbar(){
          toolbar=findViewById(R.id.toolbar);
          searchView =findViewById(R.id.sv_main);
          setSupportActionBar(toolbar);
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      }

       public SearchView getSearchView() {
           return searchView;
       }
   }
