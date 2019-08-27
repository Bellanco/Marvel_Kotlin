package com.example.evenspot_android.dependencies.modules.presentation.activity

import com.example.evenspot_android.dependencies.modules.base.scopes.PresentationScope
import com.example.evenspot_android.ui.activity.MainActivity
import com.example.presentation.presentation.activity.MainPresenter
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
