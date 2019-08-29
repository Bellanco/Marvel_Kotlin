package com.deromang.evenspot_android.dependencies.modules.presentation.activity

import com.deromang.evenspot_android.dependencies.modules.base.scopes.PresentationScope
import com.deromang.evenspot_android.ui.activity.MainActivity
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
