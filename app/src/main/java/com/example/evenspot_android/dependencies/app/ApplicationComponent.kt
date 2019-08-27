package com.example.evenspot_android.dependencies.app

import com.example.domain.tools.MainThread
import com.example.domain.tools.UseCaseExecutor
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {

    fun providesMainThread(): MainThread

    fun providesUseCaseExecutor(): UseCaseExecutor
}