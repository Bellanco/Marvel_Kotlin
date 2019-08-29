package com.deromang.domain.data

import com.google.gson.annotations.SerializedName

data class BaseResponseModel<T>(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<T>
)