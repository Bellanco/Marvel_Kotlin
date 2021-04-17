package com.deromang.mvp_kotlin.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
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

        presenter.showCharacters()

        val url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Marvel_Logo.svg/375px-Marvel_Logo.svg.png"
        ivBackground.loadImageFromUrl(url)
    }

    override fun onShowCharacters(list: BaseResponseModel<Characters>?) {
        list?.data?.let { response ->
            rvItems.layoutManager = GridLayoutManager(context, 2)

            rvItems.adapter =
                MainAdapter(response.results, context, object : MainAdapter.OnItemClickListener {
                    override fun onItemClick(characterId: Int) {
                        presenter.goToDetail(characterId)
                    }

                })
        }

    }

    override fun showError() {
        context?.toast(getString(R.string.error))
    }


}
