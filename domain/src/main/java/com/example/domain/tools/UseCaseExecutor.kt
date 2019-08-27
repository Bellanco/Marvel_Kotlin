package com.example.domain.tools

import com.example.domain.modules.UseCase

interface UseCaseExecutor {

    fun execute(useCase: UseCase)
}