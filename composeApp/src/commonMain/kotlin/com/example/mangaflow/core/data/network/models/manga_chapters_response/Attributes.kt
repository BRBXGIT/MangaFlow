package com.example.mangaflow.core.data.network.models.manga_chapters_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attributes(
    @SerialName("chapter")
    val chapter: String = "",
    @SerialName("createdAt")
    val createdAt: String = "",
    @SerialName("externalUrl")
    val externalUrl: String? = null,
    @SerialName("pages")
    val pages: Int = 0,
    @SerialName("publishAt")
    val publishAt: String = "",
    @SerialName("readableAt")
    val readableAt: String = "",
    @SerialName("title")
    val title: String = "",
    @SerialName("translatedLanguage")
    val translatedLanguage: String = "",
    @SerialName("updatedAt")
    val updatedAt: String = "",
    @SerialName("version")
    val version: Int = 0,
    @SerialName("volume")
    val volume: String = ""
)