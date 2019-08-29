package com.deromang.mvp_kotlin.dependencies.modules.presentation.activity

import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.PresentationScope
import com.deromang.presentation.presentation.activity.MainPresenter
import com.deromang.presentation.presentation.activity.MainPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @PresentationScope
    fun providesMainPresenter(mainPresenter: MainPresenterImpl): MainPresenter {
        return mainPresenter
    }

}