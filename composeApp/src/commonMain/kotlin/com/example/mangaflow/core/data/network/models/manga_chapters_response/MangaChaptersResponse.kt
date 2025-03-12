package com.example.mangaflow.core.data.network.models.manga_chapters_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MangaChaptersResponse(
    @SerialName("data")
    val data: List<Data> = listOf(),
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("response")
    val response: String = "",
    @SerialName("result")
    val result: String = "",
    @SerialName("total")
    val total: Int = 0
)