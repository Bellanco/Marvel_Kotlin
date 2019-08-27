package com.example.evenspot_android.dependencies.app

import com.example.domain.tools.MainThread
import com.example.domain.tools.UseCaseExecutor
import com.example.evenspot_android.domain.MainThreadImpl
import com.example.evenspot_android.domain.UseCaseExecutorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun providesMainThread(mainThread: MainThreadImpl) : MainThread {
        return mainThread
    }

    @Provides
    @Singleton
    fun providesUseCaseExecutor(useCaseExecutor: UseCaseExecutorImpl) : UseCaseExecutor {
        return useCaseExecutor
    }

}