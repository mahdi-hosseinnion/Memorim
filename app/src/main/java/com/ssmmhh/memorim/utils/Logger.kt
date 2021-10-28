package com.ssmmhh.memorim.utils

import android.util.Log

object Logger {
    const val DEBUG = true

    fun debugLog(tag: String, message: String) {
        if (DEBUG) {
            Log.d(tag, "debugLog: $message")
        }
    }
}