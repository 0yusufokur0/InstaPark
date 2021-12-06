package com.veripark.instapark.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load


@BindingAdapter("loadImageFromUrl")
fun ImageView.loadImage(imageUrl: String?) {

    val circularProgressDrawable = CircularProgressDrawable(this.context)
    circularProgressDrawable.strokeWidth = 10f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.setArrowDimensions(30f, 30f)
    circularProgressDrawable.start()

    imageUrl?.let {
        this.load(it){
            placeholder(circularProgressDrawable)
        }
    }
}

