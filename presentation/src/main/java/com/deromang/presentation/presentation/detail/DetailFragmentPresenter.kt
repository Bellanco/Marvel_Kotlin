package com.deromang.presentation.presentation.detail

import com.deromang.presentation.presentation.base.BasePresenter

interface DetailFragmentPresenter : BasePresenter<DetailFragmentView> {
    fun getAPIService()
    fun showCharactersDetail(characterId: Int)
    fun goToMainFragment()
}