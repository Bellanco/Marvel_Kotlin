package com.example.evenspot_android.ui.activity

import com.example.evenspot_android.R
import com.example.evenspot_android.dependencies.modules.presentation.activity.MainComponent
import com.example.evenspot_android.dependencies.modules.presentation.activity.MainModule
import com.example.evenspot_android.ui.base.BaseActivity
import com.example.presentation.presentation.activity.MainPresenter
import com.example.presentation.presentation.activity.MainView
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private var mainComponent: MainComponent? = null

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initComponent() {
        mainComponent = getActivityComponent()
            ?.mainComponent()
            ?.mainModule(MainModule())
            ?.build()

        mainComponent?.inject(this)

        presenter.setView(this)

        presenter.initialize()
    }

}
