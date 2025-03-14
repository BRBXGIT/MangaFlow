package com.example.mangaflow.feature.home_screen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.cards.MangaCard
import com.example.mangaflow.core.data.network.models.all_manga_response.Data as MangaByTitleData

@Composable
fun AllMangaLVGSection(
    state: LazyGridState,
    innerPadding: PaddingValues,
    allManga: List<MangaByTitleData>,
    onMangaCardClick: (String) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        state = state,
        columns = GridCells.Adaptive(130.dp),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 16.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(allManga) { index, manga ->
            println("TAG: ${manga.id}")
            val mangaCoverFilename = manga.relationships.filter {
                it.type == "cover_art"
            }[0].attributes?.fileName

            val mangaGenres = manga.attributes.tags.filter {
                it.attributes.group == "genre"
            }.joinToString(separator = ", ") { it.attributes.name.en }
            MangaCard(
                index = index,
                coverImageUrl = "https://uploads.mangadex.org/covers/${manga.id}/$mangaCoverFilename.256.jpg",
                title = if(manga.attributes.title.en != "") manga.attributes.title.en else "No title provided :0",
                genres = mangaGenres,
                onCardClick = {
                    onMangaCardClick(manga.id)
                }
            )
        }
    }
}