package com.example.mangaflow.core.data.network.models.all_manga

data class Data(
    val attributes: Attributes,
    val id: String,
    val relationships: List<Relationship>,
    val type: String
)