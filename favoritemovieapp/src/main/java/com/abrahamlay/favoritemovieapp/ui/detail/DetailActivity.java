package com.abrahamlay.favoritemovieapp.ui.detail;



import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.abrahamlay.favoritemovieapp.R;
import com.abrahamlay.favoritemovieapp.model.movie.ResultsItem;
import com.abrahamlay.favoritemovieapp.ui.BaseActivity;
import com.abrahamlay.favoritemovieapp.ui.Const;
import com.abrahamlay.favoritemovieapp.util.DateFormater;
import com.abrahamlay.favoritemovieapp.util.GlideHelper;

import static com.abrahamlay.favoritemovieapp.ui.Const.MOVIE_THUMBNAIL_BASE_URL_EXTRA_LARGE;

public class DetailActivity extends BaseActivity {

    private ResultsItem detail;
    private ImageView ivMovie;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detail =getIntent().getParcelableExtra(Const.PARAM_RESULT_ITEM);
        setContentView(R.layout.activity_detail);
        ivMovie=findViewById(R.id.backdrop_movie);
        toolbar=findViewById(R.id.toolbar);
        initToolbar();
    }

    private void initToolbar(){
        String url=String.format(MOVIE_THUMBNAIL_BASE_URL_EXTRA_LARGE, detail.getPosterPath());
        GlideHelper.showImage(url,ivMovie,this);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(detail.getTitle());
            String releaseDate= DateFormater.changeDateFormat("yyyy-MM-dd",detail.getReleaseDate(),"EEEE,  MMM dd, yyyy");
            getSupportActionBar().setSubtitle(releaseDate);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initDetail();
    }

    private void initDetail(){
        replaceFragment(DetailFragment.newInstance(detail),false);
    }


}
