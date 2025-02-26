package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Description(
    val en: String = "",
    @SerialName("es-la")
    val esLa: String? = null,
    val fr: String? = null,
    val id: String? = null,
    val ja: String? = null,
    val ko: String? = null,
    val pt: String? = null,
    @SerialName("pt-br")
    val ptBr: String? = null,
    val ru: String? = null,
    val th: String? = null,
    val vi: String? = null,
    val zh: String? = null,
    @SerialName("zh-hk")
    val zhHk: String? = null
)