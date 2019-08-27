package com.example.evenspot_android.ui.main


import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.evenspot_android.R
import com.example.evenspot_android.dependencies.modules.presentation.main.MainFragmentComponent
import com.example.evenspot_android.dependencies.modules.presentation.main.MainFragmentModule
import com.example.evenspot_android.ui.base.BaseFragment
import com.example.evenspot_android.ui.utils.loadImageFromUrl
import com.example.presentation.presentation.main.MainFragmentPresenter
import com.example.presentation.presentation.main.MainFragmentView
import com.squareup.picasso.Picasso
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
        val url = "https://media.moddb.com/images/members/1/414/413573/profile/thewitcheranniversary_610.jpg"
        ivBackground.loadImageFromUrl(url)
    }

}
