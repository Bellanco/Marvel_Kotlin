package com.example.evenspot_android.dependencies.modules.repository

import com.example.domain.data.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {

    override fun makeLogin(username: String, password: String): Boolean {
        return username.equals("admin", ignoreCase = true)
                && password.equals("admin", ignoreCase = true
        )
    }

}