package com.deromang.presentation.presentation.activity

import com.deromang.presentation.navigation.Navigator
import com.deromang.presentation.presentation.base.BasePresenterImpl
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