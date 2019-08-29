package com.deromang.mvp_kotlin.ui.base

import android.app.Application
import com.deromang.mvp_kotlin.dependencies.app.ApplicationComponent
import com.deromang.mvp_kotlin.dependencies.app.ApplicationModule
import com.deromang.mvp_kotlin.dependencies.app.DaggerApplicationComponent

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