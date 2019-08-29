package com.deromang.evenspot_android.dependencies.modules.base

import androidx.appcompat.app.AppCompatActivity
import com.deromang.evenspot_android.dependencies.modules.base.scopes.ActivityScope
import com.deromang.evenspot_android.dependencies.modules.presentation.activity.MainComponent
import com.deromang.evenspot_android.navigation.NavigatorImpl
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