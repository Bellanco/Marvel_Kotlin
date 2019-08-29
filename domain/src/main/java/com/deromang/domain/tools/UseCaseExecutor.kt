package com.deromang.domain.tools

import com.deromang.domain.modules.UseCase

interface UseCaseExecutor {

    fun execute(useCase: UseCase)
}