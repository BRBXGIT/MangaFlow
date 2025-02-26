package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val attributes: AttributesX = AttributesX(),
    val id: String = "",
    val relationships: List<Relationship?> = listOf(),
    val type: String = ""
)