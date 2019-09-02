package com.deromang.presentation.presentation.main

import com.deromang.domain.modules.api.APIClient
import com.deromang.domain.modules.api.APIService
import com.deromang.presentation.navigation.Navigator
import com.deromang.presentation.presentation.base.BasePresenterImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainFragmentPresenterImpl @Inject constructor(private var navigator: Navigator) :
    MainFragmentPresenter, BasePresenterImpl<MainFragmentView>() {

    private var mApiService: APIService? = null

    lateinit var mView: MainFragmentView

    override fun setView(view: MainFragmentView) {
        this.mView = view
    }

    override fun getAPIService() {
        mApiService = APIClient.getAPIService()
    }

    override fun showLeagues() {
        mApiService?.showCompetitions()
            ?.enqueue(object : Callback<com.deromang.domain.data.Response?> {
                override fun onFailure(
                    call: Call<com.deromang.domain.data.Response?>,
                    t: Throwable
                ) {
                    mView.showError()
                }

                override fun onResponse(
                    call: Call<com.deromang.domain.data.Response?>,
                    response: Response<com.deromang.domain.data.Response?>
                ) {
                    val list = response.body()
                    mView.onShowLeaguesReady(list)
                }
            })
    }

}