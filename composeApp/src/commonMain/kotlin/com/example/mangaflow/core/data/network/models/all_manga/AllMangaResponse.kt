package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class AllMangaResponse(
    val data: List<@Contextual Data>,
    val limit: Int,
    val offset: Int,
    val response: String,
    val result: String,
    val total: Int
)