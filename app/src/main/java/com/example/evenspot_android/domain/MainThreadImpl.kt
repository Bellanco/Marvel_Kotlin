package com.example.evenspot_android.domain

import android.os.Handler
import android.os.Looper
import com.example.domain.tools.MainThread
import javax.inject.Inject

class MainThreadImpl @Inject constructor() : MainThread {

    private val handler: Handler

    init {
        this.handler = Handler(Looper.getMainLooper())
    }

    override fun runOnUi(runnable: Runnable) {
        handler.post(runnable)
    }

}