package com.example.mangaflow.core.data.network.models.manga_chapters_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("attributes")
    val attributes: Attributes = Attributes(),
    @SerialName("id")
    val id: String = "",
    @SerialName("relationships")
    val relationships: List<Relationship> = listOf(),
    @SerialName("type")
    val type: String = ""
)