package com.abrahamlay.favoritemovieapp.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.abrahamlay.favoritemovieapp.R;
import com.abrahamlay.favoritemovieapp.util.DateFormater;

import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.MovieColumns.DATE;
import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.MovieColumns.DESCRIPTION;
import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.MovieColumns.TITLE;
import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.getColumnString;

public class MovieCursorAdapter extends CursorAdapter {
    public MovieCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_search_result,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        if (cursor != null){
            TextView tvMovie = view.findViewById(R.id.tv_title_movie);
            TextView tvDesc = view.findViewById(R.id.tv_desc_movie);
            TextView tvReleaseDate = view.findViewById(R.id.tv_release_date_movie);


            tvMovie.setText(getColumnString(cursor,TITLE));
            tvDesc.setText(getColumnString(cursor,DESCRIPTION));
            String releaseDate= DateFormater.changeDateFormat("yyyy-MM-dd",getColumnString(cursor,DATE),"EEEE,  MMM dd, yyyy");
            tvReleaseDate.setText(releaseDate);
        }
    }
}
