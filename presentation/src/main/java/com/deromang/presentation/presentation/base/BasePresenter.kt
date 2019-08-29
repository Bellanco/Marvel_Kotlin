package com.deromang.presentation.presentation.base

interface BasePresenter<V : BaseView> {

    fun setView(view: V)
}