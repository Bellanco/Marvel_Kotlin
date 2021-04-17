package com.deromang.domain.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type



data class ResponseModel(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val etag: String,
    val status: String
)
data class Data(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<Result>,
    val total: String
)

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: String,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)

data class Comics(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)

data class Events(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)

data class Series(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)

data class Stories(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)

data class Thumbnail(
    val extension: String,
    val path: String
)

data class Url(
    val type: String,
    val url: String
)

data class Item(
    val name: String,
    val resourceURI: String,
    val type: String?
)

data class Response(

    @SerializedName("count") val count: Int,
    @SerializedName("competitions") val competitions: List<Competitions>
)

data class Area(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)

data class Competitions(

    @SerializedName("id") val id: Int,
    @SerializedName("area") val area: Area,
    @SerializedName("name") val name: String,
    @SerializedName("code") val code: String,
    @SerializedName("plan") val plan: String,
    @SerializedName("currentSeason") val currentSeason: CurrentSeason,
    @SerializedName("numberOfAvailableSeasons") val numberOfAvailableSeasons: Int,
    @SerializedName("lastUpdated") val lastUpdated: String
)

data class CurrentSeason(

    @SerializedName("id") val id: Int,
    @SerializedName("startDate") val startDate: String,
    @SerializedName("endDate") val endDate: String,
    @SerializedName("currentMatchday") val currentMatchday: String
)

