package com.deromang.domain.data


data class Characters(
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
    val id: Int,
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



data class DetailCharacters(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)