package com.deromang.presentation.presentation.main

import com.deromang.domain.data.BaseResponseModel
import com.deromang.domain.data.DataResponse
import com.deromang.presentation.presentation.base.BaseView

interface MainFragmentView : BaseView {
    fun onShowCharacters(list: BaseResponseModel<DataResponse>?)
    fun showError()
}