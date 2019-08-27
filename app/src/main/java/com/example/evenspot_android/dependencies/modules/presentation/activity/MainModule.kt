package com.example.evenspot_android.dependencies.modules.presentation.activity

import com.example.evenspot_android.dependencies.modules.base.scopes.PresentationScope
import com.example.presentation.presentation.activity.MainPresenter
import com.example.presentation.presentation.activity.MainPresenterImpl
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