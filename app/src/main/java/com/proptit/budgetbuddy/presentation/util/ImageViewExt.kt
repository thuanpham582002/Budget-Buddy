package com.proptit.budgetbuddy.presentation.util

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(Uri.parse(url))
        .into(this)
}