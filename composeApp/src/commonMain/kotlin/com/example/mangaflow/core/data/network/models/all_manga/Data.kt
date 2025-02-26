package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val attributes: Attributes = Attributes(),
    val id: String = "",
    val relationships: List<Relationship> = listOf(),
    val type: String = ""
)