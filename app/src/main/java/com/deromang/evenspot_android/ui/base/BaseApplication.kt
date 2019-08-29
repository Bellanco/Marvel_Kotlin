package com.deromang.evenspot_android.ui.base

import android.app.Application
import com.deromang.evenspot_android.dependencies.app.ApplicationComponent
import com.deromang.evenspot_android.dependencies.app.ApplicationModule
import com.deromang.evenspot_android.dependencies.app.DaggerApplicationComponent

class BaseApplication : Application() {

    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {

        super.onCreate()

        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule())
            .build()
    }

    fun getAppComponent(): ApplicationComponent {
        return appComponent
    }


}