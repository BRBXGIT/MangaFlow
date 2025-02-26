package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    val al: String = "",
    val amz: String? = null,
    val ap: String = "",
    val bw: String? = null,
    val cdj: String? = null,
    val ebj: String? = null,
    @SerialName("engtl")
    val engTl: String? = null,
    val kt: String? = null,
    val mal: String = "",
    val mu: String = "",
    val nu: String? = null,
    val raw: String? = null
)