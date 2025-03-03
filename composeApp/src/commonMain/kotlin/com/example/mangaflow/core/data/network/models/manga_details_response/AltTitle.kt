package com.example.mangaflow.core.data.network.models.manga_details_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AltTitle(
    @SerialName("ar")
    val ar: String? = null,
    @SerialName("bn")
    val bn: String? = null,
    @SerialName("en")
    val en: String? = null,
    @SerialName("fa")
    val fa: String? = null,
    @SerialName("he")
    val he: String? = null,
    @SerialName("hi")
    val hi: String? = null,
    @SerialName("hu")
    val hu: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("ja")
    val ja: String? = null,
    @SerialName("ja-ro")
    val jaRo: String? = null,
    @SerialName("ka")
    val ka: String? = null,
    @SerialName("ko")
    val ko: String? = null,
    @SerialName("ko-ro")
    val koRo: String? = null,
    @SerialName("la")
    val la: String? = null,
    @SerialName("ne")
    val ne: String? = null,
    @SerialName("pt-br")
    val ptBr: String? = null,
    @SerialName("ro")
    val ro: String? = null,
    @SerialName("ru")
    val ru: String? = null,
    @SerialName("ta")
    val ta: String? = null,
    @SerialName("tr")
    val tr: String? = null,
    @SerialName("uk")
    val uk: String? = null,
    @SerialName("zh")
    val zh: String? = null,
    @SerialName("zh-hk")
    val zhHk: String? = null
)