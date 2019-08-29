package com.deromang.mvp_kotlin.dependencies.app

import com.deromang.domain.tools.MainThread
import com.deromang.domain.tools.UseCaseExecutor
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {

    fun providesMainThread(): MainThread

    fun providesUseCaseExecutor(): UseCaseExecutor
}