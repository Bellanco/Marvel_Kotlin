package com.deromang.mvp_kotlin.dependencies.app

import com.deromang.domain.tools.MainThread
import com.deromang.domain.tools.UseCaseExecutor
import com.deromang.mvp_kotlin.domain.MainThreadImpl
import com.deromang.mvp_kotlin.domain.UseCaseExecutorImpl
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