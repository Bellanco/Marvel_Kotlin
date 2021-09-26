package com.deromang.presentation.presentation.main

import com.deromang.presentation.presentation.base.BasePresenter

interface MainFragmentPresenter : BasePresenter<MainFragmentView> {
    fun getAPIService()
    fun showCharacters(limit: Int, offset: Int)
    fun goToDetail(characterId: Int)
}