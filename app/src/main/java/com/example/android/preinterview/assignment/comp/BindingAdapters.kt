package com.example.android.preinterview.assignment.comp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter(value = ["imageUrl"])
fun ImageView.setImageUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .thumbnail()
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}