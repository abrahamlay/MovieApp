package com.abrahamlay.movieapp.ui.detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abrahamlay.movieapp.R;
import com.abrahamlay.movieapp.db.MovieHelper;
import com.abrahamlay.movieapp.model.movie.ResultsItem;


public class DetailFragment extends Fragment {
    private static final String PARAM_DETAIL_MOVIE = "detailMovie";


    private ResultsItem detailMovie;

    private TextView tvOverview;

    private boolean isFavorite=false;

    private Menu menuInflater;

    private MovieHelper movieHelper;


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(ResultsItem detailMovie) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(PARAM_DETAIL_MOVIE, detailMovie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            detailMovie = getArguments().getParcelable(PARAM_DETAIL_MOVIE);
        }
        setHasOptionsMenu(true);
        movieHelper= new MovieHelper(getContext());
        favoriteState();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_detail, container, false);
        tvOverview =view.findViewById(R.id.detail_overview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initDetail();
        super.onActivityCreated(savedInstanceState);
    }

    private void initDetail() {
        tvOverview.setText(detailMovie.getOverview());
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_item_detail,menu);
        menuInflater=menu;
        setFavorite();
    }

    private void setFavorite() {
        if(isFavorite){
            menuInflater.getItem(0).setIcon(ContextCompat.getDrawable(getContext(),R.drawable.ic_menu_favorite_fill_white));
        }else{
            menuInflater.getItem(0).setIcon(ContextCompat.getDrawable(getContext(),R.drawable.ic_menu_favorite_blank_white));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_favorite:
                if(isFavorite) removeFromFavorite();
                else addToFavorite();

                isFavorite=!isFavorite;
                setFavorite();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void favoriteState(){
        movieHelper.open();
        ResultsItem item=movieHelper.selectItemById(String.valueOf(detailMovie.getId()));
        isFavorite = item != null;
        movieHelper.close();

    }

    private void addToFavorite() {
        movieHelper.open();
        movieHelper.insert(detailMovie);
        movieHelper.close();
    }

    private void removeFromFavorite() {
        movieHelper.open();
        movieHelper.delete(detailMovie.getId());
        movieHelper.close();
    }
}
