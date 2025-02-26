package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.Serializable

@Serializable
data class Relationship(
    val id: String = "",
    val related: String? = null,
    val type: String = ""
)