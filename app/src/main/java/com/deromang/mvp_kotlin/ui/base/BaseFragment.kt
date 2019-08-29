package com.deromang.mvp_kotlin.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import butterknife.Unbinder
import com.deromang.mvp_kotlin.dependencies.modules.base.ActivityComponent
import com.deromang.presentation.presentation.base.BaseView

abstract class BaseFragment : Fragment(), BaseView {

    private lateinit var unbinder: Unbinder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        unbinder = ButterKnife.bind(this, view)
        prepareInjection()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (unbinder != null) {
            unbinder.unbind()
        }
    }

    protected abstract fun getLayoutResId(): Int

    protected abstract fun prepareInjection()

    fun getActivityComponent(): ActivityComponent? {
        var component: ActivityComponent? = null
        if (activity is BaseActivity) {
            component = (activity as BaseActivity).getActivityComponent()
        }
        return component
    }
}