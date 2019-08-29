package com.deromang.domain.tools

interface MainThread {

    fun runOnUi(runnable: Runnable)
}