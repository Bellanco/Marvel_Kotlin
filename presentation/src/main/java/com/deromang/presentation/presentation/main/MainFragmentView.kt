package com.deromang.presentation.presentation.main

import com.deromang.domain.data.BaseResponseModel
import com.deromang.domain.data.Characters
import com.deromang.presentation.presentation.base.BaseView

interface MainFragmentView : BaseView {
    fun onShowCharacters(list: BaseResponseModel<Characters>?)
    fun showError()
}