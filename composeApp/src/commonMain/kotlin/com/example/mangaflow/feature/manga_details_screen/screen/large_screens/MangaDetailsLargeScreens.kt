package com.example.mangaflow.feature.manga_details_screen.screen.large_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.data.network.models.manga_chapters_response.Data
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.feature.manga_details_screen.screen.common.TranslateGroup
import com.example.mangaflow.feature.manga_details_screen.sections.common.MangaChapterItem
import com.example.mangaflow.feature.manga_details_screen.sections.common.MangaChaptersLoadingSection
import com.example.mangaflow.feature.manga_details_screen.sections.common.SelectTranslationGroupLCSection
import com.example.mangaflow.feature.manga_details_screen.sections.common.SelectTranslationLanguageLCSection
import com.example.mangaflow.feature.manga_details_screen.sections.large_screens.ChooseTypeOfInfoSection
import com.example.mangaflow.feature.manga_details_screen.sections.large_screens.ContentType
import com.example.mangaflow.feature.manga_details_screen.sections.large_screens.LargeScreensDescriptionSection
import com.example.mangaflow.feature.manga_details_screen.sections.large_screens.LargeScreensHeader
import kotlinx.coroutines.launch
import com.example.mangaflow.core.data.network.models.manga_details_response.Data as MangaDetailsData

@Composable
fun MangaDetailsLargeScreens(
    innerPadding: PaddingValues,
    manga: MangaDetailsData,
    onMangaChaptersListEnd: () -> Unit,
    mangaChaptersLoadingState: Boolean,
    mangaChaptersLanguage: String?,
    mangaChapters: List<Data>,
    mangaChaptersTranslationGroup: TranslateGroup?,
    onSetTranslationLanguageClick: (String) -> Unit,
    availableTranslationGroupsFiltered: List<TranslateGroup>?,
    onSetTranslationGroupClick: (TranslateGroup) -> Unit,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val drawerScope = rememberCoroutineScope()
    var translateType by rememberSaveable { mutableStateOf<TranslationType?>(null) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .fillMaxHeight()
                    .background(mColors.surfaceContainer)
                    .padding(top = innerPadding.calculateTopPadding())
            ) {
                HorizontalDivider(modifier = Modifier.fillMaxWidth())

                if(translateType == TranslationType.Language) {
                    SelectTranslationLanguageLCSection(
                        availableLanguages = manga.attributes.availableTranslatedLanguages,
                        selectedLanguage = mangaChaptersLanguage,
                        onSetLanguageClick = {
                            onSetTranslationLanguageClick(it)
                            drawerScope.launch {
                                drawerState.close()
                            }
                        },
                    )
                }

                if(translateType == TranslationType.Group) {
                    SelectTranslationGroupLCSection(
                        availableGroups = availableTranslationGroupsFiltered!!,
                        selectedGroup = mangaChaptersTranslationGroup,
                        onSetGroupClick = {
                            onSetTranslationGroupClick(it)
                            drawerScope.launch {
                                drawerState.close()
                            }
                        }
                    )
                }
            }
        },
        gesturesEnabled = false
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
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
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                LargeScreensDescriptionSection(manga.attributes.description.en)
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                ChooseTypeOfInfoSection(
                    onContentTypeChange = { chosenContentType = it },
                    chosenContentType = chosenContentType,
                    mangaChaptersLanguage = mangaChaptersLanguage,
                    mangaChaptersTranslationGroupName = mangaChaptersTranslationGroup?.name,
                    onLanguageClick = {
                        translateType = TranslationType.Language
                        drawerScope.launch {
                            drawerState.open()
                        }
                    },
                    onTranslationClick = {
                        translateType = TranslationType.Group
                        drawerScope.launch {
                            drawerState.open()
                        }
                    }
                )
            }

            if(chosenContentType == ContentType.Chapters) {
                if(mangaChaptersLanguage != null) {
                    items(mangaChapters) { chapter ->
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            MangaChapterItem(
                                volume = chapter.attributes.volume,
                                chapter = chapter.attributes.chapter,
                                title = if(chapter.attributes.title != "") chapter.attributes.title else "No title provided :0"
                            )
                        }
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
}

enum class TranslationType {
    Language, Group
}