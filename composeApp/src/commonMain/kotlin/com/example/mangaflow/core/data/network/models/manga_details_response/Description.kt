package com.example.mangaflow.core.data.network.models.manga_details_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Description(
    @SerialName("de")
    val de: String = "",
    @SerialName("en")
    val en: String = "",
    @SerialName("es-la")
    val esLa: String = "",
    @SerialName("fr")
    val fr: String = "",
    @SerialName("id")
    val id: String = "",
    @SerialName("it")
    val `it`: String = "",
    @SerialName("ja")
    val ja: String = "",
    @SerialName("ka")
    val ka: String = "",
    @SerialName("ko")
    val ko: String = "",
    @SerialName("pl")
    val pl: String = "",
    @SerialName("pt-br")
    val ptBr: String = "",
    @SerialName("ru")
    val ru: String = "",
    @SerialName("th")
    val th: String = "",
    @SerialName("zh")
    val zh: String = "",
    @SerialName("zh-hk")
    val zhHk: String = ""
)