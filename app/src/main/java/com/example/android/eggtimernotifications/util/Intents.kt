package com.example.android.eggtimernotifications.util

import android.content.Context
import android.content.Intent

inline fun <reified T> intent(packageContext: Context, block: Intent.() -> Unit = {}): Intent =
    Intent(packageContext, T::class.java).apply(block)