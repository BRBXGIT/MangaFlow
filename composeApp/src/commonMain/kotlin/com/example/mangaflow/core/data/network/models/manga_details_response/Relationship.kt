package com.example.mangaflow.core.data.network.models.manga_details_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Relationship(
    @SerialName("id")
    val id: String = "",
    @SerialName("related")
    val related: String? = null,
    @SerialName("type")
    val type: String = ""
)