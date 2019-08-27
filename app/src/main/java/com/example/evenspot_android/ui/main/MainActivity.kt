package com.example.evenspot_android.ui.main

import com.example.evenspot_android.R
import com.example.evenspot_android.dependencies.modules.presentation.main.MainComponent
import com.example.evenspot_android.dependencies.modules.presentation.main.MainModule
import com.example.evenspot_android.dependencies.utils.toast
import com.example.evenspot_android.ui.base.BaseActivity
import com.example.presentation.presentation.main.MainPresenter
import com.example.presentation.presentation.main.MainView
import kotlinx.android.synthetic.main.activity_main.*
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

    override fun setTextWelcome() {

        tvInit.text = getString(R.string.my_name)

        tvInit.setOnClickListener { toast(getString(R.string.good_morning)) }
    }


}
