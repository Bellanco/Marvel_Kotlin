package com.example.evenspot_android.dependencies.modules.presentation.main

import com.example.evenspot_android.dependencies.modules.base.scopes.PresentationScope
import com.example.evenspot_android.ui.main.MainFragment
import com.example.presentation.presentation.main.MainFragmentPresenter
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