package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AltTitle(
    val ar: String? = null,
    val en: String? = null,
    val es: String? = null,
    @SerialName("es-la")
    val esLa: String? = null,
    val fr: String? = null,
    val id: String? = null,
    val it: String? = null,
    val ja: String? = null,
    @SerialName("ja-ro")
    val jaRo: String? = null,
    val ko: String? = null,
    @SerialName("ko-ro")
    val koRo: String? = null,
    val ne: String? = null,
    @SerialName("pt-br")
    val ptBr: String? = null,
    val ru: String? = null,
    val th: String? = null,
    val tr: String? = null,
    val vi: String? = null,
    val zh: String? = null,
    @SerialName("zh-hk")
    val zhHk: String? = null
)