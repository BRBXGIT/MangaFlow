package com.example.mangaflow.feature.home_screen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mangaflow.feature.home_screen.screen.HomeScreen
import com.example.mangaflow.feature.home_screen.screen.MangaScreenVM
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

fun NavGraphBuilder.homeScreen(
    navController: NavController,
    mangaScreenVM: MangaScreenVM,
    showNavRail: Boolean
) = composable<HomeScreenRoute> {
    HomeScreen(
        navController = navController,
        viewModel = mangaScreenVM,
        showNavRail = showNavRail
    )
}