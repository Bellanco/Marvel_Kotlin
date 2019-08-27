package com.example.evenspot_android.dependencies.modules.repository

import com.example.domain.data.repository.UserRepository
import com.example.evenspot_android.dependencies.modules.base.scopes.PresentationScope
import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule {

    @Provides
    @PresentationScope
    fun providesUserRepository(userRepository: UserRepositoryImpl): UserRepository {
        return userRepository
    }

}
