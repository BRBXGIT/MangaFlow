package com.example.mangaflow.core.data.network.models.manga_chapters_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AltName(
    @SerialName("en")
    val en: String = ""
)