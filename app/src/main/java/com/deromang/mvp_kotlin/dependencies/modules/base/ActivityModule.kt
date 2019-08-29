package com.deromang.mvp_kotlin.dependencies.modules.base

import androidx.appcompat.app.AppCompatActivity
import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.ActivityScope
import com.deromang.mvp_kotlin.dependencies.modules.presentation.activity.MainComponent
import com.deromang.mvp_kotlin.navigation.NavigatorImpl
import com.deromang.presentation.navigation.Navigator
import dagger.Module
import dagger.Provides

@Module(subcomponents = [MainComponent::class])
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun providesNavigator(): Navigator {
        return NavigatorImpl(activity)
    }

}