package com.deromang.domain.modules.api

import com.deromang.domain.data.BaseResponseModel
import com.deromang.domain.data.Response
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("competitions")
    fun showCompetitions(): Call<BaseResponseModel<Response>>

}