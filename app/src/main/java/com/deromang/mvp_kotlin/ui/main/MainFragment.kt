package com.deromang.mvp_kotlin.ui.main


import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.deromang.domain.modules.api.APIClient
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.dependencies.modules.presentation.main.MainFragmentComponent
import com.deromang.mvp_kotlin.dependencies.modules.presentation.main.MainFragmentModule
import com.deromang.mvp_kotlin.ui.base.BaseFragment
import com.deromang.mvp_kotlin.ui.main.adapter.MainAdapter
import com.deromang.mvp_kotlin.ui.utils.addItems
import com.deromang.mvp_kotlin.ui.utils.loadImageFromUrl
import com.deromang.presentation.presentation.main.MainFragmentPresenter
import com.deromang.presentation.presentation.main.MainFragmentView
import kotlinx.android.synthetic.main.fragment_main.*
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

        setupView()
    }

    private fun setupView() {

        presenter.getAPIService()

        presenter.showLeagues()

        val url = "https://media.moddb.com/images/members/1/414/413573/profile/thewitcheranniversary_610.jpg"
        ivBackground.loadImageFromUrl(url)

        val items = addItems()

        rvItems.layoutManager = GridLayoutManager(context, 2)

        rvItems.adapter = MainAdapter(items, context)
    }

}
