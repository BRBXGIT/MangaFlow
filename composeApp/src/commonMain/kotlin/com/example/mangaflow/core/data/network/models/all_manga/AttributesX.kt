package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.Serializable

@Serializable
data class AttributesX(
    val description: DescriptionX? = DescriptionX(),
    val group: String = "",
    val name: Name = Name(),
    val version: Int = 0
)