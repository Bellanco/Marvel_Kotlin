package com.deromang.presentation.presentation.detail

import com.deromang.domain.data.BaseResponseModel
import com.deromang.domain.data.Characters
import com.deromang.domain.data.DetailCharacters
import com.deromang.presentation.presentation.base.BaseView

interface DetailFragmentView : BaseView {

    fun onShowCharactersDetail(list: BaseResponseModel<DetailCharacters>?)
    fun showError()
}