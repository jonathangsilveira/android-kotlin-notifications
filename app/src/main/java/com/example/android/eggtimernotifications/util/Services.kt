package com.example.android.eggtimernotifications.util

import android.content.Context
import androidx.core.content.ContextCompat

inline fun <reified T> systemService(context: Context): T =
    ContextCompat.getSystemService(context, T::class.java) as T