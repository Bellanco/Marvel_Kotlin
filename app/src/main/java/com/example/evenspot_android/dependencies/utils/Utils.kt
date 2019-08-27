package com.example.evenspot_android.dependencies.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.bumptech.glide.Glide

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun ImageView.fromUrl(url: String) {
    if (url.isNotEmpty())
        Glide.with(this).load(url).into(this)

}

fun ProgressBar.show() {
    if (this.visibility == View.GONE)
        this.visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    if (this.visibility == View.VISIBLE)
        this.visibility = View.GONE
}