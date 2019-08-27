package com.example.domain.modules

interface UseCaseCallback<T : UseCaseResponse> {

    fun onRespone(result: T)
}