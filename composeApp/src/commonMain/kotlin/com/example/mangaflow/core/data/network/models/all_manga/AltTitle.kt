package com.example.mangaflow.core.data.network.models.all_manga


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AltTitle(
    @SerialName("de")
    val de: String? = null,
    @SerialName("en")
    val en: String? = null,
    @SerialName("es")
    val es: String? = null,
    @SerialName("es-la")
    val esLa: String? = null,
    @SerialName("fr")
    val fr: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("it")
    val it: String? = null,
    @SerialName("ja")
    val ja: String? = null,
    @SerialName("ja-ro")
    val jaRo: String? = null,
    @SerialName("ko")
    val ko: String? = null,
    @SerialName("ko-ro")
    val koRo: String? = null,
    @SerialName("nl")
    val nl: String? = null,
    @SerialName("pl")
    val pl: String? = null,
    @SerialName("pt-br")
    val ptBr: String? = null,
    @SerialName("ru")
    val ru: String? = null,
    @SerialName("th")
    val th: String? = null,
    @SerialName("vi")
    val vi: String? = null,
    @SerialName("zh")
    val zh: String? = null,
    @SerialName("zh-hk")
    val zhHk: String? = null
)