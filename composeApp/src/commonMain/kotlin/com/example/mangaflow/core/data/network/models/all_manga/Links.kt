package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.SerialName

data class Links(
    val al: String,
    val amz: String,
    val ap: String,
    val bw: String,
    val cdj: String,
    val ebj: String,
    @SerialName("engtl")
    val engTl: String,
    val kt: String,
    val mal: String,
    val mu: String,
    val raw: String
)