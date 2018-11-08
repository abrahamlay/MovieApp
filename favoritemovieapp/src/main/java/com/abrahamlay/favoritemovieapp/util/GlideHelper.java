package com.abrahamlay.favoritemovieapp.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;

public class GlideHelper {
    public static void showImage(String url, ImageView imageView, Context context){
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .priority(Priority.HIGH);

        RequestBuilder<Drawable> requestBuilder = Glide.with(context)
                .load(url);
        requestBuilder
                .thumbnail(Glide.with(context)
                        .load(url))
                .apply(options)
                .load(url)
                .into(imageView);
    }
}
