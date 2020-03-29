package com.example.android.eggtimernotifications.util

import android.content.Context
import androidx.core.content.ContextCompat

inline fun <reified T> Context.systemService(): T =
    ContextCompat.getSystemService(this, T::class.java) as T