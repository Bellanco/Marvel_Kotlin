package com.example.evenspot_android.dependencies.modules.presentation.main

import com.example.evenspot_android.dependencies.modules.base.scopes.PresentationScope
import com.example.presentation.presentation.main.MainPresenter
import com.example.presentation.presentation.main.MainPresenterImpl
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