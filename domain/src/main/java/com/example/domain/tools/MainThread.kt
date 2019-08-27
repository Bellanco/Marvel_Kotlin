package com.example.domain.tools

interface MainThread {

    fun runOnUi(runnable: Runnable)
}