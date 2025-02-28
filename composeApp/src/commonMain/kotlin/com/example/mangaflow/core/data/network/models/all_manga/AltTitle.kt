package com.example.mangaflow.core.data.network.models.all_manga


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AltTitle(
    @SerialName("ar")
    val ar: String? = null,
    @SerialName("el")
    val el: String? = null,
    @SerialName("en")
    val en: String? = null,
    @SerialName("es-la")
    val esLa: String? = null,
    @SerialName("fr")
    val fr: String? = null,
    @SerialName("ja")
    val ja: String? = null,
    @SerialName("ja-ro")
    val jaRo: String? = null,
    @SerialName("ko")
    val ko: String? = null,
    @SerialName("ko-ro")
    val koRo: String? = null,
    @SerialName("lt")
    val lt: String? = null,
    @SerialName("ne")
    val ne: String? = null,
    @SerialName("pl")
    val pl: String? = null,
    @SerialName("pt-br")
    val ptBr: String? = null,
    @SerialName("ru")
    val ru: String? = null,
    @SerialName("th")
    val th: String? = null,
    @SerialName("tr")
    val tr: String? = null,
    @SerialName("vi")
    val vi: String? = null,
    @SerialName("zh")
    val zh: String? = null,
    @SerialName("zh-hk")
    val zhHk: String? = null
)