package com.abrahamlay.favoritemovieapp.ui.viewholder;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abrahamlay.movieapp.R;
import com.abrahamlay.movieapp.model.movie.ResultsItem;
import com.abrahamlay.movieapp.util.DateFormater;
import com.abrahamlay.movieapp.util.GlideHelper;

import static com.abrahamlay.movieapp.ui.Const.MOVIE_THUMBNAIL_BASE_URL_EXTRA_SMALL;

public class SearchResultViewHolder extends RecyclerView.ViewHolder{

    private final ImageView ivMovie;
    private final TextView tvMovie;
    private final TextView tvDesc;
    private final TextView tvReleaseDate;

    public SearchResultViewHolder(@NonNull View itemView) {
        super(itemView);
        ivMovie =itemView.findViewById(R.id.iv_movie_thumbnail);
        tvMovie =itemView.findViewById(R.id.tv_title_movie);
        tvDesc =itemView.findViewById(R.id.tv_desc_movie);
        tvReleaseDate =itemView.findViewById(R.id.tv_release_date_movie);
    }

    public void bindData(ResultsItem item){
        String url=String.format(MOVIE_THUMBNAIL_BASE_URL_EXTRA_SMALL, item.getPosterPath());
        tvMovie.setText(item.getTitle());

        GlideHelper.showImage(url,ivMovie,itemView.getContext());
        tvDesc.setText(item.getOverview());

        String releaseDate= DateFormater.changeDateFormat("yyyy-MM-dd",item.getReleaseDate(),"EEEE,  MMM dd, yyyy");
        tvReleaseDate.setText(releaseDate);
    }

    public void setOnClickListener(View.OnClickListener listener){
        itemView.setOnClickListener(listener);
    }
}