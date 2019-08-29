package com.deromang.evenspot_android.dependencies.modules.presentation.main

import com.deromang.evenspot_android.dependencies.modules.base.scopes.PresentationScope
import com.deromang.presentation.presentation.main.MainFragmentPresenter
import com.deromang.presentation.presentation.main.MainFragmentPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {

    @Provides
    @PresentationScope
    fun providesMainFragmentPresenter(mainFragmentPresenter: MainFragmentPresenterImpl): MainFragmentPresenter {
        return mainFragmentPresenter
    }
}