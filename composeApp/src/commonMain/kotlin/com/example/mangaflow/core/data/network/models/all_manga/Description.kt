package com.example.mangaflow.core.data.network.models.all_manga


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Description(
    @SerialName("en")
    val en: String = "",
    @SerialName("es")
    val es: String? = null,
    @SerialName("fr")
    val fr: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("pl")
    val pl: String? = null,
    @SerialName("pt-br")
    val ptBr: String? = null,
    @SerialName("ru")
    val ru: String? = null
)