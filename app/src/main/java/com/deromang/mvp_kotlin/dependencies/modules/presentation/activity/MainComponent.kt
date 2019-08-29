package com.deromang.mvp_kotlin.dependencies.modules.presentation.activity

import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.PresentationScope
import com.deromang.mvp_kotlin.ui.activity.MainActivity
import com.deromang.presentation.presentation.activity.MainPresenter
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
