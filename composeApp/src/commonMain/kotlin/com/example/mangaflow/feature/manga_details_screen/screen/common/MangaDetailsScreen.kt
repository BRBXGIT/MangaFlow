package com.example.mangaflow.feature.manga_details_screen.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.feature.common.NavRail
import com.example.mangaflow.feature.manga_details_screen.screen.compact_screens.MangaDetailsCompactScreens
import com.example.mangaflow.feature.manga_details_screen.screen.large_screens.MangaDetailsLargeScreens
import com.example.mangaflow.feature.manga_details_screen.sections.common.MangaDetailsScreenTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MangaDetailsScreen(
    navController: NavController,
    showNavRail: Boolean,
    viewModel: MangaDetailsScreenVM,
    mangaId: String
) {
    //Use launched effect to don't fetch data multiple times cause of recompositions
    val manga = viewModel.mangaDetails.collectAsStateWithLifecycle().value
    LaunchedEffect(manga) {
        if(manga == null) {
            viewModel.fetchMangaDetails(mangaId)
        }
    }
    val mangaLoadingState  = viewModel.mangaDetailsLoading.collectAsStateWithLifecycle().value

    val topBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    manga?.let {
        Scaffold(
            topBar = {
                MangaDetailsScreenTopBar(
                    mangaTitle = if(manga.attributes.title.en != "") manga.attributes.title.en else "No title provided :0",
                    mangaLoadingState = mangaLoadingState,
                    scrollBehavior = topBarScrollBehavior,
                    onNavIconClick = { navController.navigateUp() },
                    showNavRail = showNavRail
                )
            },
            modifier = Modifier
                .fillMaxSize()
                .background(mColors.background)
                .then(
                    if(showNavRail) {
                        Modifier.padding(start = 80.dp)
                    } else {
                        Modifier.padding(start = 0.dp)
                    }
                )
                .nestedScroll(topBarScrollBehavior.nestedScrollConnection)
        ) { innerPadding ->
            val mangaChaptersLanguage by viewModel.mangaChaptersLanguage.collectAsStateWithLifecycle()
            val mangaChaptersLoadingState by viewModel.mangaChaptersLoading.collectAsStateWithLifecycle()
            val mangaChapters by viewModel.mangaChapters.collectAsStateWithLifecycle()
            val mangaChaptersTranslationGroup by viewModel.selectedMangaChaptersScanlationGroup.collectAsStateWithLifecycle()
            val availableTranslationGroupsFiltered by viewModel.availableMangaChaptersScanlationGroups.collectAsStateWithLifecycle()

            if(showNavRail) {
                MangaDetailsLargeScreens(
                    innerPadding = innerPadding,
                    manga = manga,
                    mangaChaptersLanguage = mangaChaptersLanguage,
                    mangaChapters = mangaChapters,
                    mangaChaptersLoadingState = mangaChaptersLoadingState,
                    mangaChaptersTranslationGroup = mangaChaptersTranslationGroup,
                    availableTranslationGroupsFiltered = availableTranslationGroupsFiltered,
                    onMangaChaptersListEnd = {
                        if(mangaChaptersLanguage != null) {
                            viewModel.fetchMangaChapters(mangaId)
                        }
                    },
                    onSetTranslationLanguageClick = {
                        viewModel.setMangaChaptersLanguage(it)
                        viewModel.fetchMangaChapters(
                            mangaId = manga.id,
                            onComplete = { viewModel.setMangaScanlationGroups() }
                        )
                    },
                    onSetTranslationGroupClick = {
                        viewModel.setMangaScanlationGroupId(it.name, it.id)
                        viewModel.fetchMangaChapters(manga.id)
                    }
                )
            } else {
                MangaDetailsCompactScreens(
                    innerPadding = innerPadding,
                    manga = manga,
                    mangaChaptersLoadingState = mangaChaptersLoadingState,
                    mangaChaptersLanguage = mangaChaptersLanguage,
                    mangaChapters = mangaChapters,
                    availableTranslationGroupsFiltered = availableTranslationGroupsFiltered,
                    mangaChaptersTranslationGroup = mangaChaptersTranslationGroup,
                    onMangaChaptersListEnd = {
                        if(mangaChaptersLanguage != null) {
                            viewModel.fetchMangaChapters(mangaId)
                        }
                    },
                    onSetTranslationLanguageClick = {
                        viewModel.setMangaChaptersLanguage(it)
                        viewModel.fetchMangaChapters(
                            mangaId = manga.id,
                            onComplete = { viewModel.setMangaScanlationGroups() }
                        )
                    },
                    onSetTranslationGroupClick = {
                        viewModel.setMangaScanlationGroupId(it.name, it.id)
                        viewModel.fetchMangaChapters(manga.id)
                    },
                )
            }
        }
    }

    if(showNavRail) {
        NavRail(navController)
    }
}