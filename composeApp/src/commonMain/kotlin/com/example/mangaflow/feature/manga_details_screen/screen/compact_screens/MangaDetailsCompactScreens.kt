package com.example.mangaflow.feature.manga_details_screen.screen.compact_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.feature.manga_details_screen.sections.common.convertReadOrBuyLinks
import com.example.mangaflow.feature.manga_details_screen.sections.common.convertTrackLinks
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensMangaAdditionalInfoSection
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensDescriptionSection
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensHeader
import com.example.mangaflow.core.data.network.models.manga_details_response.Data as MangaDetailsData

@Composable
fun MangaDetailsCompactScreens(
    innerPadding: PaddingValues,
    manga: MangaDetailsData
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(24.dp),
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
                titleEng = manga.attributes.title.en,
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

            CompactScreensMangaAdditionalInfoSection(
                genres = genreList.drop(1), //Don't know why but first genre always is empty string, that's why i simply drop it
                readOrBuyLinks = readOrBuyLinks,
                trackLinks = trackLinks,
                altTitles = filteredAltTitles,
                onLinkClick = {  }
            )
        }

        item {
            Spacer(modifier = Modifier.height(0.dp))
        }
    }
}