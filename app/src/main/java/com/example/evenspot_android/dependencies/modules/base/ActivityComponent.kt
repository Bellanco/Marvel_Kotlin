package com.example.evenspot_android.dependencies.modules.base

import com.example.evenspot_android.dependencies.app.ApplicationComponent
import com.example.evenspot_android.dependencies.modules.base.scopes.ActivityScope
import com.example.evenspot_android.dependencies.modules.presentation.activity.MainComponent
import com.example.evenspot_android.dependencies.modules.presentation.main.MainFragmentComponent
import com.example.presentation.navigation.Navigator
import dagger.Component

@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface ActivityComponent {

    abstract fun providesNavigator(): Navigator

    abstract fun mainComponent(): MainComponent.Builder

    abstract fun mainFragmentComponent(): MainFragmentComponent.Builder

}