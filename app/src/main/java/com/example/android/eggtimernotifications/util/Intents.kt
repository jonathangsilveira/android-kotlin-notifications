package com.example.android.eggtimernotifications.util

import android.content.Context
import android.content.Intent

inline fun <reified T> Context.newIntent(block: Intent.() -> Unit = {}): Intent =
    Intent(this, T::class.java).apply(block)