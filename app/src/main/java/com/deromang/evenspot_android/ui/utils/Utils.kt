package com.deromang.evenspot_android.ui.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.squareup.picasso.Picasso

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun ImageView.loadImageFromUrl(url: String) {
    if (url.isNotEmpty())
        Picasso.get().load(url).into(this)
}

fun ProgressBar.show() {
    if (this.visibility == View.GONE)
        this.visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    if (this.visibility == View.VISIBLE)
        this.visibility = View.GONE
}