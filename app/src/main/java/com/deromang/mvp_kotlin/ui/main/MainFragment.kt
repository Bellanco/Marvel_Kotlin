package com.deromang.mvp_kotlin.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deromang.domain.data.BaseResponseModel
import com.deromang.domain.data.Characters
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.dependencies.modules.presentation.main.MainFragmentComponent
import com.deromang.mvp_kotlin.dependencies.modules.presentation.main.MainFragmentModule
import com.deromang.mvp_kotlin.ui.base.BaseFragment
import com.deromang.mvp_kotlin.ui.main.adapter.MainAdapter
import com.deromang.mvp_kotlin.ui.utils.loadImageFromUrl
import com.deromang.mvp_kotlin.ui.utils.toast
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

    var offset = 0
    val limit = 20
    var quantity = 0

    companion object {

        private const val IS_ACCESS = "isAccess"

        fun newInstance(): Fragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putBoolean(IS_ACCESS, false)
            fragment.arguments = args
            return fragment
        }
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

        presenter.showCharacters(limit, offset)

        setupAdapter()

        val url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Marvel_Logo.svg/375px-Marvel_Logo.svg.png"
        ivBackground.loadImageFromUrl(url)
    }

    private fun setupAdapter() {
        rvItems.layoutManager = GridLayoutManager(context, 2)

        rvItems.adapter =
            MainAdapter(requireContext(), object : MainAdapter.OnListener {
                override fun onItemClick(characterId: Int) {
                    presenter.goToDetail(characterId)
                }

                override fun onLoadCharacters() {
                    if (offset < quantity)
                        presenter.showCharacters(limit, offset)
                }

            })
    }

    override fun onShowCharacters(list: BaseResponseModel<Characters>?) {
        list?.data?.let { response ->
            quantity = response.total.toInt()
            offset += limit
            (rvItems.adapter as MainAdapter).addAll(response.results)
        }

    }

    override fun showError() {
        context?.toast(getString(R.string.error))
    }


}
