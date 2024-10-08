package com.example.assignment8

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, image: String?){
    image?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imageView)
    }
}

@BindingAdapter("characterName")
fun bindText(textView: TextView, fullname: String?){
    fullname?.let {
        textView.text = fullname.toString()
    }
}

@BindingAdapter("surName")
fun bindSurnameText(textView: TextView, nickname: String?){
    nickname?.let {
        textView.text = nickname.toString()
    }
}