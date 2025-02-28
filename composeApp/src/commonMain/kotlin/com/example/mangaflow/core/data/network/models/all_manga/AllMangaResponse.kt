package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllMangaResponse(
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