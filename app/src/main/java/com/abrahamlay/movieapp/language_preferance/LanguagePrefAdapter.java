package com.abrahamlay.movieapp.language_preferance;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by GIGABYTE on 20/11/2017.
 */

public class LanguagePrefAdapter extends ArrayAdapter<String> {

    private int mSelectedIndex=-1;

    public LanguagePrefAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public void setSelection(int position) {
        mSelectedIndex = position;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = super.getView(position, convertView, parent);

        if (position == mSelectedIndex) {
            itemView.setBackgroundColor(Color.rgb(200, 200, 200));
            if (itemView instanceof TextView) {
                ((TextView) itemView).setTextSize(20);
            }
        } else {
            itemView.setBackgroundColor(Color.TRANSPARENT);
            if (itemView instanceof TextView) {
                ((TextView) itemView).setTextSize(14);
            }
        }

        return itemView;
    }
}
