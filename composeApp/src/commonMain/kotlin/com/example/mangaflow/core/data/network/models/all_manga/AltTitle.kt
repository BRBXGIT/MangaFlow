package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.SerialName

data class AltTitle(
    val en: String,
    @SerialName("es-la")
    val esLa: String,
    val fr: String,
    val ja: String,
    @SerialName("ja-ro")
    val jaRo: String,
    val ko: String,
    val pl: String,
    val ru: String,
    val vi: String,
    val zh: String
)