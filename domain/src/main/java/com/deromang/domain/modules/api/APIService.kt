package com.deromang.domain.modules.api

import com.deromang.domain.data.BaseResponseModel
import com.deromang.domain.data.Characters
import com.deromang.domain.data.DetailCharacters
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {


    @GET("/v1/public/characters")
    fun getCharacteres(
        @Query("limit") offset: Int,
        @Query("offset") limit: Int
    ): Call<BaseResponseModel<Characters>>

    @GET("/v1/public/characters/{characterId}")
    fun getCharactersDetail(@Path("characterId") characterId: Int): Call<BaseResponseModel<DetailCharacters>>

}