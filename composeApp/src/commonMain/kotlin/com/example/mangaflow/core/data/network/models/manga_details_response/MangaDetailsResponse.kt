package com.example.mangaflow.core.data.network.models.manga_details_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MangaDetailsResponse(
    @SerialName("data")
    val data: Data = Data(),
    @SerialName("response")
    val response: String = "",
    @SerialName("result")
    val result: String = ""
)