package com.example.mangaflow.core.data.network.models.all_manga


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Description(
    @SerialName("de")
    val de: String? = null,
    @SerialName("en")
    val en: String = "",
    @SerialName("es")
    val es: String? = null,
    @SerialName("es-la")
    val esLa: String? = null,
    @SerialName("fr")
    val fr: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("it")
    val `it`: String? = null,
    @SerialName("ja")
    val ja: String? = null,
    @SerialName("ko")
    val ko: String? = null,
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
    @SerialName("zh-hk")
    val zhHk: String? = null
)