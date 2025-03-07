package com.example.mangaflow.core.data.network.models.manga_details_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Relationship(
    @SerialName("attributes")
    val attributes: AttributesXX? = AttributesXX(),
    @SerialName("id")
    val id: String = "",
    @SerialName("related")
    val related: String? = "",
    @SerialName("type")
    val type: String = ""
)