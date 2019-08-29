package com.deromang.domain.data.repository

interface UserRepository {

    fun makeLogin(username: String, password: String): Boolean
}