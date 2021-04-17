package com.deromang.presentation.navigation

interface Navigator {

    fun goBack()

    fun onBackPressed()

    fun goToMainFragment()

    fun goToDetailFragment(characterId: Int)
}