package com.example.evenspot_android.dependencies.modules.base

import androidx.appcompat.app.AppCompatActivity
import com.example.evenspot_android.dependencies.modules.base.scopes.ActivityScope
import com.example.evenspot_android.dependencies.modules.presentation.main.MainComponent
import com.example.evenspot_android.navigation.NavigatorImpl
import com.example.presentation.navigation.Navigator
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