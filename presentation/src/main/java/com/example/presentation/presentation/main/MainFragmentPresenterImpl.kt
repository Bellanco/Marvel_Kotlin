package com.example.presentation.presentation.main

import com.example.presentation.navigation.Navigator
import com.example.presentation.presentation.base.BasePresenterImpl
import javax.inject.Inject

class MainFragmentPresenterImpl @Inject constructor(private var navigator: Navigator) :
    MainFragmentPresenter, BasePresenterImpl<MainFragmentView>() {

    lateinit var mView: MainFragmentView

    override fun setView(view: MainFragmentView) {
        this.mView = view
    }

    fun initialize() {
        navigator.goToMainFragment()
    }

}