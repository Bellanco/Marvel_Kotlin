package com.deromang.mvp_kotlin.dependencies.modules.repository

import com.deromang.domain.data.repository.UserRepository
import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.PresentationScope
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
