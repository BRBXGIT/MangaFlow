package com.example.mangaflow.core.data.network.models.manga_chapters_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Relationship(
    @SerialName("attributes")
    val attributes: AttributesX? = AttributesX(),
    @SerialName("id")
    val id: String = "",
    @SerialName("type")
    val type: String = ""
)