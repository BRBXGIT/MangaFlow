package com.example.mangaflow.core.data.network.models.manga_details_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AttributesXX(
    @SerialName("createdAt")
    val createdAt: String = "",
    @SerialName("description")
    val description: String = "",
    @SerialName("fileName")
    val fileName: String = "",
    @SerialName("locale")
    val locale: String = "",
    @SerialName("updatedAt")
    val updatedAt: String = "",
    @SerialName("version")
    val version: Int = 0,
    @SerialName("volume")
    val volume: String = ""
)