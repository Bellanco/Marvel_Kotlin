package com.example.presentation.presentation.main

import com.example.presentation.presentation.base.BasePresenter

interface MainPresenter : BasePresenter {

    fun setView(mainView: MainView)

    fun initialize()
}