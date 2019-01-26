package com.abrahamlay.favoritemovieapp.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abrahamlay.favoritemovieapp.R;
import com.abrahamlay.favoritemovieapp.model.movie.ResultsItem;
import com.abrahamlay.favoritemovieapp.ui.OnItemClickListener;
import com.abrahamlay.favoritemovieapp.ui.viewholder.SearchResultViewHolder;
import com.abrahamlay.favoritemovieapp.ui.widget.CursorRecyclerViewAdapter;
import com.abrahamlay.favoritemovieapp.util.DateFormater;

import java.util.List;

import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.MovieColumns.DATE;
import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.MovieColumns.DESCRIPTION;
import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.MovieColumns.TITLE;
import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.getColumnString;

/**
 * Created by abrahamlay on 17/08/2018.
 */

public class MovieAdapter extends CursorRecyclerViewAdapter<RecyclerView.ViewHolder> {

    private final OnItemClickListener mListener;

    public MovieAdapter(Context context, Cursor cursor,OnItemClickListener mListener) {
        super(context,cursor);
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        return new SearchResultViewHolder(inflater.inflate(R.layout.item_search_result,viewGroup,false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        if (cursor != null){
            final ResultsItem item= new ResultsItem()
                    .setTitle(getColumnString(cursor,TITLE))
                    .setReleaseDate(getColumnString(cursor,DATE))
                    .setOverview(getColumnString(cursor,DESCRIPTION));

            final SearchResultViewHolder searchResultViewHolder=(SearchResultViewHolder) viewHolder;
            searchResultViewHolder.bindData(item);

            searchResultViewHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClicked(item);
                }
            });

        }
    }
}
