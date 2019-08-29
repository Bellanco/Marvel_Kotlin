package com.deromang.mvp_kotlin.domain

import android.os.Handler
import android.os.Looper
import com.deromang.domain.tools.MainThread
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