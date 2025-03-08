package com.example.mangaflow.feature.manga_details_screen.screen.large_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.feature.manga_details_screen.sections.large_screens.LargeScreensHeader
import com.example.mangaflow.core.data.network.models.manga_details_response.Data as MangaDetailsData

@Composable
fun MangaDetailsLargeScreens(
    innerPadding: PaddingValues,
    manga: MangaDetailsData
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = innerPadding.calculateBottomPadding())
    ) {
        item {
            val mangaCoverArtFileName = manga.relationships.filter {
                it.type == "cover_art"
            }[0].attributes?.fileName
            val mangaTitleJap = manga.attributes.altTitles.filter {
                it.ja is String
            }[0].ja
            val authorsList = manga.relationships.filter {
                it.type == "author"
            }
            val authors = authorsList.joinToString(", ") { it.attributes?.name.toString() }
            LargeScreensHeader(
                coverImageUrl = "https://uploads.mangadex.org/covers/${manga.id}/$mangaCoverArtFileName",
                titleEng = manga.attributes.title.en,
                titleJap = mangaTitleJap.toString(),
                authors = authors,
                topPadding = innerPadding.calculateTopPadding()
            )
        }
    }
}