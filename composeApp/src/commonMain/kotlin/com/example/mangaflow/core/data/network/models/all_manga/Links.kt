package com.example.mangaflow.core.data.network.models.all_manga


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("al")
    val al: String? = null,
    @SerialName("amz")
    val amz: String? = null,
    @SerialName("ap")
    val ap: String? = null,
    @SerialName("bw")
    val bw: String? = null,
    @SerialName("cdj")
    val cdj: String? = null,
    @SerialName("ebj")
    val ebj: String? = null,
    @SerialName("engtl")
    val engTl: String? = null,
    @SerialName("kt")
    val kt: String? = null,
    @SerialName("mal")
    val mal: String? = null,
    @SerialName("mu")
    val mu: String = "",
    @SerialName("nu")
    val nu: String? = null,
    @SerialName("raw")
    val raw: String? = null
)