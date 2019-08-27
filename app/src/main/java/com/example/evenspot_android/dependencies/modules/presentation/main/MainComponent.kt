package com.example.evenspot_android.dependencies.modules.presentation.main

import com.example.evenspot_android.dependencies.modules.base.scopes.PresentationScope
import com.example.evenspot_android.ui.main.MainActivity
import com.example.presentation.presentation.main.MainPresenter
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
@PresentationScope
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun providesMainPresenter(): MainPresenter

    @Subcomponent.Builder
    interface Builder {

        fun mainModule(module: MainModule): Builder

        fun build(): MainComponent

    }

}
