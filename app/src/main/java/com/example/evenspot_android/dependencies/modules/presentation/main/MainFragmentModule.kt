package com.example.evenspot_android.dependencies.modules.presentation.main

import com.example.evenspot_android.dependencies.modules.base.scopes.PresentationScope
import com.example.presentation.presentation.main.MainFragmentPresenter
import com.example.presentation.presentation.main.MainFragmentPresenterImpl
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