package com.example.presentation.presentation.main

import com.example.presentation.navigation.Navigator
import com.example.presentation.presentation.base.BaseView
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(private var navigator: Navigator) : MainPresenter {

    private var view: MainView? = null

    override fun setView(view: MainView) {
        this.view = view
    }

    override fun initialize() {
        view?.setTextWelcome()
    }


}