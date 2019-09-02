package com.deromang.presentation.presentation.main

import com.deromang.domain.data.Response
import com.deromang.presentation.presentation.base.BaseView

interface MainFragmentView : BaseView {
    fun onShowLeaguesReady(list: Response?)
    fun showError()
}