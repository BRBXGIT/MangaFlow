package com.example.mangaflow.core.data.network.models.all_manga


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AttributesX(
    @SerialName("description")
    val description: DescriptionX? = DescriptionX(),
    @SerialName("group")
    val group: String = "",
    @SerialName("name")
    val name: Name = Name(),
    @SerialName("version")
    val version: Int = 0
)