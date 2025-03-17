package com.example.mangaflow.feature.manga_details_screen.screen.compact_screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography
import com.example.mangaflow.feature.manga_details_screen.sections.common.convertReadOrBuyLinks
import com.example.mangaflow.feature.manga_details_screen.sections.common.convertTrackLinks
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensDescriptionSection
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensHeader
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensMangaAdditionalInfoSection
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.MangaChapterItem
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.MangaChaptersLoadingSection
import com.example.mangaflow.core.data.network.models.manga_chapters_response.Data as MangaChaptersResponseData
import com.example.mangaflow.core.data.network.models.manga_details_response.Data as MangaDetailsData

@Composable
fun MangaDetailsCompactScreens(
    innerPadding: PaddingValues,
    manga: MangaDetailsData,
    onMangaChaptersListEnd: () -> Unit,
    onSetTranslationLanguageClick: () -> Unit,
    onSetTranslationGroupClick: () -> Unit,
    mangaChaptersLoadingState: Boolean,
    mangaChaptersLanguage: String?,
    mangaChapters: List<MangaChaptersResponseData>
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

    LazyColumn(
        state = state,
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
            val authors = manga.relationships.filter {
                it.type == "author"
            }.joinToString(", ") { it.attributes?.name.toString() }
            CompactScreensHeader(
                coverImageUrl = "https://uploads.mangadex.org/covers/${manga.id}/$mangaCoverArtFileName",
                titleEng = if(manga.attributes.title.en == "") "No title provided :0" else manga.attributes.title.en,
                titleJap = mangaTitleJap.toString(),
                authors = authors,
                topPadding = innerPadding.calculateTopPadding()
            )
        }

        item {
            CompactScreensDescriptionSection(manga.attributes.description.en)
        }

        item {
            val trackLinks = convertTrackLinks(manga.attributes.links)
            val readOrBuyLinks = convertReadOrBuyLinks(manga.attributes.links)
            val genreList = mutableListOf("")
            manga.attributes.tags.filter {
                it.attributes.group == "genre"
            }.forEach {
                genreList += it.attributes.name.en
            }
            val filteredAltTitles = manga.attributes.altTitles.flatMap { altTitle ->
                listOfNotNull(
                    "ar" to altTitle.ar,
                    "en" to altTitle.en,
                    "fa" to altTitle.fa,
                    "he" to altTitle.he,
                    "id" to altTitle.id,
                    "ja" to altTitle.ja,
                    "ja-ro" to altTitle.jaRo,
                    "ka" to altTitle.ka,
                    "ko" to altTitle.ko,
                    "ko-ro" to altTitle.koRo,
                    "pt-br" to altTitle.ptBr,
                    "ru" to altTitle.ru,
                    "tr" to altTitle.tr,
                    "uk" to altTitle.uk,
                    "zh" to altTitle.zh,
                    "zh-hk" to altTitle.zhHk
                ).filter { it.second != null }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CompactScreensMangaAdditionalInfoSection(
                    genres = genreList.drop(1), //Don't know why but first genre always is empty string, that's why i simply drop it
                    readOrBuyLinks = readOrBuyLinks,
                    trackLinks = trackLinks,
                    altTitles = filteredAltTitles,
                    onLinkClick = {  }
                )

                Button(
                    shape = mShapes.extraSmall,
                    onClick = {
                        onSetTranslationLanguageClick()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Set translation language",
                        style = mTypography.bodyLarge
                    )
                }

                AnimatedVisibility(
                    visible = mangaChaptersLanguage != null,
                    enter = fadeIn(tween(300)) + expandVertically(tween(300)),
                    exit = fadeOut(tween(300)) + shrinkVertically(tween(300))
                ) {
                    Button(
                        shape = mShapes.extraSmall,
                        onClick = { onSetTranslationGroupClick() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = "Set translation group",
                            style = mTypography.bodyLarge
                        )
                    }
                }
            }
        }

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

        item {
            Spacer(modifier = Modifier.height(0.dp))
        }
    }
}