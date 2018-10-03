package com.abrahamlay.movieapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abrahamlay.movieapp.R;
import com.abrahamlay.movieapp.model.movie.ResultsItem;
import com.abrahamlay.movieapp.ui.OnItemClickListener;
import com.abrahamlay.movieapp.ui.viewholder.SearchResultViewHolder;

import java.util.List;

/**
 * Created by abrahamlay on 17/08/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ResultsItem> mItemList;
    private OnItemClickListener mListener;


    public MovieAdapter(List<ResultsItem> mItemList, OnItemClickListener mListener) {
        this.mItemList = mItemList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        return new SearchResultViewHolder(inflater.inflate(R.layout.item_search_result,viewGroup,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        final ResultsItem item=mItemList.get(i);

        final SearchResultViewHolder SearchResultViewHolder=(SearchResultViewHolder) viewHolder;
        SearchResultViewHolder.bindData(item);
        SearchResultViewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClicked(SearchResultViewHolder.itemView,item,SearchResultViewHolder.getAdapterPosition());
            }
        });


    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
