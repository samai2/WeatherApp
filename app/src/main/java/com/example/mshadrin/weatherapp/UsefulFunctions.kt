package com.example.mshadrin.weatherapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

val ViewGroup.childViews: List<View>
    get() = (0 until childCount).map { getChildAt(it) }

operator fun ViewGroup.get(position: Int): View = getChildAt(position)