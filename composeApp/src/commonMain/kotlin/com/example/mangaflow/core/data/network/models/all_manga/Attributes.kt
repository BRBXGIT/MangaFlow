package com.example.mangaflow.core.data.network.models.all_manga


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attributes(
    @SerialName("altTitles")
    val altTitles: List<AltTitle> = listOf(),
    @SerialName("availableTranslatedLanguages")
    val availableTranslatedLanguages: List<String> = listOf(),
    @SerialName("chapterNumbersResetOnNewVolume")
    val chapterNumbersResetOnNewVolume: Boolean = false,
    @SerialName("contentRating")
    val contentRating: String = "",
    @SerialName("createdAt")
    val createdAt: String = "",
    @SerialName("description")
    val description: Description = Description(),
    @SerialName("isLocked")
    val isLocked: Boolean = false,
    @SerialName("lastChapter")
    val lastChapter: String? = "",
    @SerialName("lastVolume")
    val lastVolume: String? = "",
    @SerialName("latestUploadedChapter")
    val latestUploadedChapter: String = "",
    @SerialName("links")
    val links: Links? = Links(),
    @SerialName("originalLanguage")
    val originalLanguage: String = "",
    @SerialName("publicationDemographic")
    val publicationDemographic: String? = "",
    @SerialName("state")
    val state: String = "",
    @SerialName("status")
    val status: String = "",
    @SerialName("tags")
    val tags: List<Tag> = listOf(),
    @SerialName("title")
    val title: Title = Title(),
    @SerialName("updatedAt")
    val updatedAt: String = "",
    @SerialName("version")
    val version: Int = 0,
    @SerialName("year")
    val year: Int? = 0
)