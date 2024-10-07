package com.example.assignment10.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.assignment10.R

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, thumbnail: String) {
    Glide.with(imageView.context)
        .load(thumbnail)
        .apply(
            RequestOptions()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image))
        .into(imageView)
}