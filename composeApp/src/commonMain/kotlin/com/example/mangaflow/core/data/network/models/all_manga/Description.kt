package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.SerialName

data class Description(
    val en: String,
    @SerialName("es-la")
    val esLa: String,
    val ru: String,
    val zh: String
)