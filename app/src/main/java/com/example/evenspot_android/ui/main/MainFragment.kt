package com.example.evenspot_android.ui.main


import androidx.fragment.app.Fragment
import com.example.evenspot_android.R
import com.example.evenspot_android.dependencies.modules.presentation.main.MainFragmentComponent
import com.example.evenspot_android.dependencies.modules.presentation.main.MainFragmentModule
import com.example.evenspot_android.ui.base.BaseFragment
import com.example.presentation.presentation.activity.MainPresenter
import com.example.presentation.presentation.activity.MainView
import com.example.presentation.presentation.base.BaseView
import com.example.presentation.presentation.main.MainFragmentPresenter
import com.example.presentation.presentation.main.MainFragmentView
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment(), MainFragmentView {

    private var component: MainFragmentComponent? = null

    @Inject
    lateinit var presenter: MainFragmentPresenter


    fun newInstance(): Fragment {
        val fragment = MainFragment()
        return fragment
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_main
    }

    override fun prepareInjection() {
        component =
            getActivityComponent()?.mainFragmentComponent()
                ?.mainFragmentModule(MainFragmentModule())?.build()

        component?.inject(this)

        presenter.setView(this)
    }

}
