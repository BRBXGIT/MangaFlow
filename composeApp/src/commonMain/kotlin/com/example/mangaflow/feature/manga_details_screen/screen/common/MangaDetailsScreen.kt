package com.example.mangaflow.feature.manga_details_screen.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.feature.common.NavRail
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
                    mangaTitle = manga.attributes.title.en,
                    mangaLoadingState = mangaLoadingState,
                    scrollBehavior = topBarScrollBehavior,
                    onNavIconClick = { navController.navigateUp() }
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

        }
    }

    if(showNavRail) {
        NavRail(navController)
    }
}