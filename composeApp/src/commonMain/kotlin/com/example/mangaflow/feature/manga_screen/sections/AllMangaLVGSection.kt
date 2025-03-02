package com.example.mangaflow.feature.manga_screen.sections

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
import com.example.mangaflow.core.data.network.models.all_manga.Data as MangaByTitleData
import com.example.mangaflow.core.design_system.cards.MangaCard

@Composable
fun AllMangaLVGSection(
    state: LazyGridState,
    innerPadding: PaddingValues,
    allManga: List<MangaByTitleData>
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
            val mangaCoverFilename = manga.relationships.filter {
                it.type == "cover_art"
            }[0].attributes?.fileName

            MangaCard(
                index = index,
                coverImageUrl = "https://uploads.mangadex.org/covers/${manga.id}/$mangaCoverFilename"
            )
        }
    }
}