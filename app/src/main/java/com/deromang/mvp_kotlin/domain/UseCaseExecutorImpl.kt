package com.deromang.mvp_kotlin.domain

import com.deromang.domain.modules.UseCase
import com.deromang.domain.tools.UseCaseExecutor
import java.lang.IllegalArgumentException
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class UseCaseExecutorImpl @Inject constructor() : UseCaseExecutor {


    private val CORE_POOL_SIZE = 1

    private val MAX_POOL_SIZE = 10

    private val KEEP_ALIVE_TIME = 300L

    private val TIME_UNIT = TimeUnit.SECONDS

    private val WORK_QUEUE = LinkedBlockingQueue<Runnable>()


    private val threadPoolExecutor: ThreadPoolExecutor

    init {
        this.threadPoolExecutor = ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE)
    }



    override fun execute(useCase: UseCase) {
        if (useCase == null) {
            throw IllegalArgumentException("UseCase must not be null")
        }
        threadPoolExecutor.submit { useCase.run() }
    }
}