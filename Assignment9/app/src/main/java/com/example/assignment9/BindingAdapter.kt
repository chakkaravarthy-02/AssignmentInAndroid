package com.example.assignment9

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.assignment9.overview.FlagStatus

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, flag: String?){
    flag?.let {
        Glide.with(imageView.context)
            .load(flag)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imageView)
    }
}

@BindingAdapter("statusImage")
fun bindStatus(imageView: ImageView, status: FlagStatus?){
    when(status) {
        FlagStatus.LOADING -> imageView.setImageResource(R.drawable.loading_animation)
        FlagStatus.DONE -> imageView.visibility = View.GONE
        FlagStatus.ERROR -> imageView.setImageResource(R.drawable.ic_connection_error)
        null -> imageView.setImageResource(R.drawable.loading_animation)
    }
}