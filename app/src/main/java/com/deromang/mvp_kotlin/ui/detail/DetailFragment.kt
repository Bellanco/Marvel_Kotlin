package com.deromang.mvp_kotlin.ui.detail


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.deromang.domain.data.BaseResponseModel
import com.deromang.domain.data.DetailCharacters
import com.deromang.domain.data.Url
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.dependencies.modules.presentation.detail.DetailFragmentComponent
import com.deromang.mvp_kotlin.dependencies.modules.presentation.detail.DetailFragmentModule
import com.deromang.mvp_kotlin.ui.base.BaseFragment
import com.deromang.mvp_kotlin.ui.detail.adapter.DetailAdapter
import com.deromang.mvp_kotlin.ui.utils.loadImageFromUrl
import com.deromang.mvp_kotlin.ui.utils.toast
import com.deromang.presentation.presentation.detail.DetailFragmentPresenter
import com.deromang.presentation.presentation.detail.DetailFragmentView
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.rvReferences
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : BaseFragment(), DetailFragmentView {

    private var component: DetailFragmentComponent? = null

    private var characterId: Int? = null

    @Inject
    lateinit var presenter: DetailFragmentPresenter

    companion object {

        private const val IS_ACCESS = "isAccess"

        fun newInstance(characterId: Int): Fragment {
            val fragment = DetailFragment()
            fragment.characterId = characterId
            val args = Bundle()
            args.putBoolean(IS_ACCESS, false)
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_detail
    }

    override fun prepareInjection() {
        component =
            getActivityComponent()?.detailFragmentComponent()
                ?.detailFragmentModule(DetailFragmentModule())?.build()

        component?.inject(this)

        presenter.setView(this)

        setupView()
    }

    private fun setupView() {

        presenter.getAPIService()

        characterId?.let {
            presenter.showCharactersDetail(it)
        }

        fabBack.setOnClickListener { presenter.goToMainFragment() }
    }


    override fun onShowCharactersDetail(model: BaseResponseModel<DetailCharacters>?) {
        model?.data?.let { response ->
            if (response.results.isNotEmpty()) {
                tvDetailName.text = response.results[0].name
                val references = arrayListOf<Url>()
                for (url in response.results[0].urls)
                    references.add(url)
                context?.let { context ->
                    rvReferences.layoutManager = GridLayoutManager(context, 1)

                    rvReferences.adapter =
                        DetailAdapter(
                            references,
                            context,
                            object : DetailAdapter.OnItemClickListener {
                                override fun onItemClick(url: String) {
                                    val browserIntent = Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(url)
                                    )
                                    startActivity(browserIntent)

                                }
                            })
                }
            }
            val thumbnail = response.results[0].thumbnail
            ivDetail.loadImageFromUrl("""${thumbnail.path}.${thumbnail.extension}""")
        }
    }

    override fun showError() {
        context?.toast(getString(R.string.error))
    }


}
