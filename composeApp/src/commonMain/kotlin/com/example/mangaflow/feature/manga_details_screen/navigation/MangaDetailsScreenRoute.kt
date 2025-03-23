package com.example.mangaflow.feature.manga_details_screen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.mangaflow.feature.manga_details_screen.screen.common.MangaDetailsScreen
import com.example.mangaflow.feature.manga_details_screen.screen.common.MangaDetailsScreenVM
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
data class MangaDetailsScreenRoute(
    val mangaId: String
)

@OptIn(KoinExperimentalAPI::class)
fun NavGraphBuilder.mangaDetailsScreen(
    navController: NavController,
    bigScreen: Boolean
) = composable<MangaDetailsScreenRoute> {
    val mangaDetailsScreenVM = koinViewModel<MangaDetailsScreenVM>()
    val mangaId = it.toRoute<MangaDetailsScreenRoute>().mangaId

    MangaDetailsScreen(
        navController = navController,
        bigScreen = bigScreen,
        viewModel = mangaDetailsScreenVM,
        mangaId = mangaId
    )
}