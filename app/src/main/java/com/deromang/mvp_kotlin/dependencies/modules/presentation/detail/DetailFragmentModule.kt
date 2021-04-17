package com.deromang.mvp_kotlin.dependencies.modules.presentation.detail

import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.PresentationScope
import com.deromang.presentation.presentation.detail.DetailFragmentPresenter
import com.deromang.presentation.presentation.detail.DetailFragmentPresenterImpl
import com.deromang.presentation.presentation.main.MainFragmentPresenter
import com.deromang.presentation.presentation.main.MainFragmentPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class DetailFragmentModule {

    @Provides
    @PresentationScope
    fun providesDetailFragmentPresenter(detailFragmentPresenter: DetailFragmentPresenterImpl): DetailFragmentPresenter {
        return detailFragmentPresenter
    }

}