package com.example.mangaflow.core.data.network.models.all_manga

import kotlinx.serialization.Serializable

@Serializable
data class Attributes(
    val altTitles: List<AltTitle> = listOf(),
    val availableTranslatedLanguages: List<String> = listOf(),
    val chapterNumbersResetOnNewVolume: Boolean = false,
    val contentRating: String = "",
    val createdAt: String = "",
    val description: Description = Description(),
    val isLocked: Boolean = false,
    val lastChapter: String = "",
    val lastVolume: String = "",
    val latestUploadedChapter: String = "",
    val links: Links = Links(),
    val originalLanguage: String = "",
    val publicationDemographic: String? = "",
    val state: String = "",
    val status: String = "",
    val tags: List<Tag> = listOf(),
    val title: Title = Title(),
    val updatedAt: String = "",
    val version: Int = 0,
    val year: Int? = 0
)