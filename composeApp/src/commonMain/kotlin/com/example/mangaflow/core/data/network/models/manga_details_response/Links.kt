package com.example.mangaflow.core.data.network.models.manga_details_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("al")
    val al: String = "",
    @SerialName("amz")
    val amz: String = "",
    @SerialName("ap")
    val ap: String = "",
    @SerialName("bw")
    val bw: String = "",
    @SerialName("ebj")
    val ebj: String = "",
    @SerialName("engtl")
    val engTl: String = "",
    @SerialName("kt")
    val kt: String = "",
    @SerialName("mal")
    val mal: String = "",
    @SerialName("mu")
    val mu: String = "",
    @SerialName("nu")
    val nu: String = "",
    @SerialName("raw")
    val raw: String = ""
)