package com.deromang.mvp_kotlin.dependencies.modules.presentation.detail

import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.PresentationScope
import com.deromang.mvp_kotlin.ui.detail.DetailFragment
import com.deromang.mvp_kotlin.ui.main.MainFragment
import com.deromang.presentation.presentation.detail.DetailFragmentPresenter
import com.deromang.presentation.presentation.main.MainFragmentPresenter
import dagger.Subcomponent

@Subcomponent(modules = [DetailFragmentModule::class])
@PresentationScope
interface DetailFragmentComponent {

    fun inject(mainFragment: DetailFragment)

    fun providesDetailFragmentPresenter(): DetailFragmentPresenter

    @Subcomponent.Builder
    interface Builder {

        fun detailFragmentModule(module: DetailFragmentModule): Builder

        fun build(): DetailFragmentComponent

    }

}