package com.example.mangaflow.feature.manga_details_screen.screen.large_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.data.network.models.manga_chapters_response.Data
import com.example.mangaflow.feature.manga_details_screen.sections.common.MangaChapterItem
import com.example.mangaflow.feature.manga_details_screen.sections.common.MangaChaptersLoadingSection
import com.example.mangaflow.feature.manga_details_screen.sections.large_screens.ChooseTypeOfInfoSection
import com.example.mangaflow.feature.manga_details_screen.sections.large_screens.ContentType
import com.example.mangaflow.feature.manga_details_screen.sections.large_screens.LargeScreensDescriptionSection
import com.example.mangaflow.feature.manga_details_screen.sections.large_screens.LargeScreensHeader
import com.example.mangaflow.core.data.network.models.manga_details_response.Data as MangaDetailsData

@Composable
fun MangaDetailsLargeScreens(
    innerPadding: PaddingValues,
    manga: MangaDetailsData,
    onMangaChaptersListEnd: () -> Unit,
    mangaChaptersLoadingState: Boolean,
    mangaChaptersLanguage: String?,
    mangaChapters: List<Data>,
) {
    val state = rememberLazyListState()
    LaunchedEffect(state) {
        snapshotFlow { state.canScrollForward }
            .collect { canScrollForward ->
                if(!canScrollForward) {
                    onMangaChaptersListEnd()
                }
            }
    }

    var chosenContentType by rememberSaveable { mutableStateOf(ContentType.Chapters) }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(48.dp),
        state = state,
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
            val genreList = mutableListOf("")
            manga.attributes.tags.filter {
                it.attributes.group == "genre"
            }.forEach {
                genreList += it.attributes.name.en
            }
            val authors = authorsList.joinToString(", ") { it.attributes?.name.toString() }
            LargeScreensHeader(
                coverImageUrl = "https://uploads.mangadex.org/covers/${manga.id}/$mangaCoverArtFileName",
                titleEng = manga.attributes.title.en,
                titleJap = mangaTitleJap.toString(),
                authors = authors,
                topPadding = innerPadding.calculateTopPadding(),
                genres = genreList.drop(1) //Don't know why but first genre always is empty string, that's why i simply drop it
            )
        }

        item {
            LargeScreensDescriptionSection(manga.attributes.description.en)
        }

        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                ChooseTypeOfInfoSection(
                    onContentTypeChange = { chosenContentType = it },
                    chosenContentType = chosenContentType
                )
            }
        }

        if(chosenContentType == ContentType.Chapters) {
            if(mangaChaptersLanguage != null) {
                items(mangaChapters) { chapter ->
                    MangaChapterItem(
                        volume = chapter.attributes.volume,
                        chapter = chapter.attributes.chapter,
                        title = if(chapter.attributes.title != "") chapter.attributes.title else "No title provided :0"
                    )
                }
            }

            if((mangaChaptersLanguage != null) and (mangaChaptersLoadingState)) {
                item {
                    MangaChaptersLoadingSection()
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(0.dp))
        }
    }
}