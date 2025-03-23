package com.example.mangaflow.feature.home_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mangaflow.core.design_system.snackbars.ObserveAsEvents
import com.example.mangaflow.core.design_system.snackbars.SnackbarController
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.feature.common.NavBar
import com.example.mangaflow.feature.common.NavRail
import com.example.mangaflow.feature.home_screen.sections.AllMangaLVGSection
import com.example.mangaflow.feature.home_screen.sections.HomeScreenTopBar
import com.example.mangaflow.feature.manga_details_screen.navigation.MangaDetailsScreenRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenVM,
    bigScreen: Boolean
) {
    //Snackbars stuff
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    ObserveAsEvents(flow = SnackbarController.events, snackbarHostState) { event ->
        scope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()

            val result = snackbarHostState.showSnackbar(
                message = event.message,
                actionLabel = event.action?.name,
                duration = SnackbarDuration.Indefinite,
                withDismissAction = true
            )

            if(result == SnackbarResult.ActionPerformed) {
                event.action?.action?.invoke()
            }
        }
    }

    //Use launched effect to don't fetch data multiple times due to recomposition
    val allManga = viewModel.allManga.collectAsStateWithLifecycle().value
    val allMangaLoadingState = viewModel.allMangaLoading.collectAsStateWithLifecycle().value
    LaunchedEffect(allManga) {
        if(allManga.isEmpty()) {
            viewModel.fetchAllManga()
        }
    }

    val topBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        bottomBar = {
            if(!bigScreen) {
                NavBar(navController)
            }
        },
        topBar = { HomeScreenTopBar(topBarScrollBehavior, allMangaLoadingState) },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        modifier = Modifier
            .fillMaxSize()
            .then(
                if(bigScreen) {
                    Modifier.padding(start = 80.dp)
                } else {
                    Modifier.padding(start = 0.dp)
                }
            )
            .background(mColors.background)
            .nestedScroll(topBarScrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        val state = rememberLazyGridState()
        LaunchedEffect(state) {
            snapshotFlow { state.canScrollForward }
                .collect { canScrollForward ->
                    if (!canScrollForward) {
                        viewModel.fetchAllManga()
                    }
                }
        }

        AllMangaLVGSection(
            state = state,
            innerPadding = innerPadding,
            allManga = allManga,
            onMangaCardClick = { mangaId ->
                navController.navigate(
                    MangaDetailsScreenRoute(mangaId)
                )
            }
        )
    }

    if(bigScreen) {
        NavRail(navController)
    }
}