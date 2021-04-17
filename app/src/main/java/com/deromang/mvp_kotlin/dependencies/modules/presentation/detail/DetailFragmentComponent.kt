package com.deromang.mvp_kotlin.dependencies.modules.presentation.main

import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.PresentationScope
import com.deromang.mvp_kotlin.ui.main.MainFragment
import com.deromang.presentation.presentation.main.MainFragmentPresenter
import dagger.Subcomponent

@Subcomponent(modules = [MainFragmentModule::class])
@PresentationScope
interface MainFragmentComponent {

    fun inject(mainFragment: MainFragment)

    fun providesMainFragmentPresenter(): MainFragmentPresenter

    @Subcomponent.Builder
    interface Builder {

        fun mainFragmentModule(module: MainFragmentModule): Builder

        fun build(): MainFragmentComponent

    }

}