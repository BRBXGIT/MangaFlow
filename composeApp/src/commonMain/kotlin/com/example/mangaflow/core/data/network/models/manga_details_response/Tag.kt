package com.example.mangaflow.core.data.network.models.manga_details_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("attributes")
    val attributes: AttributesX = AttributesX(),
    @SerialName("id")
    val id: String = "",
    @SerialName("relationships")
    val relationships: List<Relationship?> = listOf(),
    @SerialName("type")
    val type: String = ""
)