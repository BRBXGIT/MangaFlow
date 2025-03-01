package com.example.mangaflow.core.data.network.models.all_manga


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Description(
    @SerialName("en")
    val en: String = "",
    @SerialName("es")
    val es: String? = null,
    @SerialName("es-la")
    val esLa: String? = null,
    @SerialName("fr")
    val fr: String? = null,
    @SerialName("it")
    val it: String? = null,
    @SerialName("ja")
    val ja: String? = null,
    @SerialName("pt-br")
    val ptBr: String? = null,
    @SerialName("ru")
    val ru: String? = null
)