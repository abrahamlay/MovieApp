package com.abrahamlay.favoritemovieapp.ui.detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abrahamlay.favoritemovieapp.R;
import com.abrahamlay.favoritemovieapp.model.movie.ResultsItem;


public class DetailFragment extends Fragment {
    private static final String PARAM_DETAIL_MOVIE = "detailMovie";


    private ResultsItem detailMovie;
    private TextView tvOverview;


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
}
