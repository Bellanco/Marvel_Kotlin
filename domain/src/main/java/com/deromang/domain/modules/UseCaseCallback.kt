package com.deromang.domain.modules

interface UseCaseCallback<T : UseCaseResponse> {

    fun onRespone(result: T)
}