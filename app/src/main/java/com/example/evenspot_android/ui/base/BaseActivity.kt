package com.example.evenspot_android.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.evenspot_android.dependencies.app.ApplicationComponent
import com.example.evenspot_android.dependencies.modules.base.ActivityComponent
import com.example.evenspot_android.dependencies.modules.base.ActivityModule
import com.example.evenspot_android.dependencies.modules.base.DaggerActivityComponent
import com.example.presentation.presentation.base.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView  {

    private var unbinder: Unbinder? = null

    private var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(getLayoutResId())

        unbinder = ButterKnife.bind(this)

        prepareInjection()

        initComponent()

    }

    abstract fun getLayoutResId(): Int


    fun getAppComponent(): ApplicationComponent {
        return (application as BaseApplication).getAppComponent()
    }

    fun getActivityComponent(): ActivityComponent? {
        return activityComponent
    }


    private fun prepareInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .applicationComponent(getAppComponent())
            .activityModule(ActivityModule(this))
            .build()
    }
}