package com.example.mangaflow.feature.manga_details_screen.screen.compact_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.feature.manga_details_screen.sections.common.convertReadOrBuyLinks
import com.example.mangaflow.feature.manga_details_screen.sections.common.convertTrackLinks
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensAltTitlesSection
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensDescriptionSection
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensGenresLRSection
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensHeader
import com.example.mangaflow.feature.manga_details_screen.sections.compact_screens.CompactScreensMangaLinksLRSection
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
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Genres: ",
                    modifier = Modifier.padding(start = 16.dp)
                )

                val genreList = mutableListOf("")
                manga.attributes.tags.filter {
                    it.attributes.group == "genre"
                }.forEach {
                    genreList += it.attributes.name.en
                }
                CompactScreensGenresLRSection(genreList.drop(1)) //Don't know why but first item of list is always empty string
            }
        }

        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Read or buy: ",
                    modifier = Modifier.padding(start = 16.dp)
                )

                val readOrBuyLinks = convertReadOrBuyLinks(manga.attributes.links)
                CompactScreensMangaLinksLRSection(readOrBuyLinks)
            }
        }

        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Track: ",
                    modifier = Modifier.padding(start = 16.dp)
                )

                val trackLinks = convertTrackLinks(manga.attributes.links)
                CompactScreensMangaLinksLRSection(trackLinks)
            }
        }

        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "Alt titles: ",
                    modifier = Modifier.padding(start = 16.dp)
                )

                val mangaAltTitles = manga.attributes.altTitles
                CompactScreensAltTitlesSection(mangaAltTitles)
            }
        }

        item {
            Spacer(modifier = Modifier.height(0.dp))
        }
    }
}