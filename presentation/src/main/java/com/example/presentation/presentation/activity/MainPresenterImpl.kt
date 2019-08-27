package com.example.presentation.presentation.activity

import com.example.presentation.navigation.Navigator
import com.example.presentation.presentation.base.BasePresenterImpl
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(private var navigator: Navigator) : MainPresenter,
    BasePresenterImpl<MainView>() {

    lateinit var mView: MainView

    override fun setView(view: MainView) {
        mView = view
    }

    override fun initialize() {
        navigator.goToMainFragment()
    }

}