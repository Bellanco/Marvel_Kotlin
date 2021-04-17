package com.deromang.presentation.presentation.detail

import com.deromang.domain.data.BaseResponseModel
import com.deromang.domain.data.Characters
import com.deromang.domain.data.DetailCharacters
import com.deromang.domain.modules.api.APIClient
import com.deromang.domain.modules.api.APIService
import com.deromang.presentation.navigation.Navigator
import com.deromang.presentation.presentation.base.BasePresenterImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailFragmentPresenterImpl @Inject constructor(private var navigator: Navigator) :
    DetailFragmentPresenter, BasePresenterImpl<DetailFragmentView>() {

    private var mApiService: APIService? = null

    lateinit var mView: DetailFragmentView

    override fun setView(view: DetailFragmentView) {
        this.mView = view
    }

    override fun getAPIService() {
        mApiService = APIClient.getAPIService()
    }

    override fun showCharactersDetail(characterId: Int) {
        mApiService?.getCharactersDetail(characterId)
            ?.enqueue(object : Callback<BaseResponseModel<DetailCharacters>> {
                override fun onFailure(
                    call: Call<BaseResponseModel<DetailCharacters>>,
                    t: Throwable
                ) {
                    mView.showError()
                }

                override fun onResponse(
                    call: Call<BaseResponseModel<DetailCharacters>>,
                    response: Response<BaseResponseModel<DetailCharacters>>
                ) {
                    val list = response.body()
                    mView.onShowCharactersDetail(list)
                }
            })
    }

    override fun goToMainFragment() {
        navigator.goToMainFragment()
    }

}