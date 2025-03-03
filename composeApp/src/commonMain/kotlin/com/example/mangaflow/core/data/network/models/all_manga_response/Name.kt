package com.example.mangaflow.core.data.network.models.all_manga_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Name(
    @SerialName("en")
    val en: String = ""
)