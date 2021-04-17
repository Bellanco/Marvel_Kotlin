package com.deromang.presentation.presentation.main

import com.deromang.domain.data.BaseResponseModel
import com.deromang.domain.data.DataResponse
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

    override fun showCharacters() {
        mApiService?.getCharacteres()
            ?.enqueue(object : Callback<BaseResponseModel<DataResponse>> {
                override fun onFailure(call: Call<BaseResponseModel<DataResponse>>, t: Throwable) {
                    mView.showError()
                }

                override fun onResponse(
                    call: Call<BaseResponseModel<DataResponse>>,
                    response: Response<BaseResponseModel<DataResponse>>
                ) {
                    val list = response.body()
                    mView.onShowCharacters(list)
                }
            })
    }
    override fun showCharactersDetail(characterId: Int) {
        mApiService?.getCharacteresDetail(characterId)
            ?.enqueue(object : Callback<BaseResponseModel<DataResponse>> {
                override fun onFailure(call: Call<BaseResponseModel<DataResponse>>, t: Throwable) {
                    mView.showError()
                }

                override fun onResponse(
                    call: Call<BaseResponseModel<DataResponse>>,
                    response: Response<BaseResponseModel<DataResponse>>
                ) {
                    val list = response.body()
                    mView.onShowCharacters(list)
                }
            })
    }

}