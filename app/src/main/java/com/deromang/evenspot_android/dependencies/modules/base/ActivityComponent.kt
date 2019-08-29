package com.deromang.evenspot_android.dependencies.modules.base

import com.deromang.evenspot_android.dependencies.app.ApplicationComponent
import com.deromang.evenspot_android.dependencies.modules.base.scopes.ActivityScope
import com.deromang.evenspot_android.dependencies.modules.presentation.activity.MainComponent
import com.deromang.evenspot_android.dependencies.modules.presentation.main.MainFragmentComponent
import com.deromang.presentation.navigation.Navigator
import dagger.Component

@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface ActivityComponent {

    fun providesNavigator(): Navigator

    fun mainComponent(): MainComponent.Builder

    fun mainFragmentComponent(): MainFragmentComponent.Builder

}