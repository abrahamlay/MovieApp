package com.abrahamlay.favoritemovieapp.ui.widget;

import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abrahamlay.favoritemovieapp.R;

/**
 * Created by abrahamlay on 17/08/2018.
 */

public class EmptyViewHolder {
    private final View rootView;
    private final TextView tvMessage;
    private final ImageView icon;

    public EmptyViewHolder(View rootView) {
        this.rootView = rootView;
        this.tvMessage = rootView.findViewById(R.id.tv_message);
        this.icon = rootView.findViewById(R.id.iv_empty);
    }

    public void showOnNetworkError(){
        show();
        setMessage(R.string.network_error);
    }

    public void showOnTimeout(){
        show();
        setMessage(R.string.timeout_error);
    }

    public void setEmptyResult(){
        show();
        setMessage(R.string.movie_cant_be_found);
    }

    public void setMessage(String text) {
        if (text != null) tvMessage.setText(text);
    }

    public EmptyViewHolder setMessage(Spanned text) {
        if (text != null) tvMessage.setText(text);
        return this;
    }

    private void setMessage(int textResId) {
        tvMessage.setText(textResId);
    }

    public EmptyViewHolder setIcon(int iconResId) {
        if (iconResId != 0) {
            icon.setVisibility(View.VISIBLE);
            icon.setImageResource(iconResId);
        }

        return this;
    }

    public EmptyViewHolder showIcon(boolean show) {
        icon.setVisibility(show ? View.VISIBLE : View.GONE);
        return this;
    }

    public void hide() {
        rootView.setVisibility(View.GONE);
    }

    public void show() {
        rootView.setVisibility(View.VISIBLE);
    }

}
