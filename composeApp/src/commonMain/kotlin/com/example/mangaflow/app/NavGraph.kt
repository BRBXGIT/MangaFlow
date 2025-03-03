package com.example.mangaflow.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mangaflow.common.functions.showNavRail
import com.example.mangaflow.feature.bookmarks_screen.navigation.bookmarksScreen
import com.example.mangaflow.feature.home_screen.navigation.HomeScreenRoute
import com.example.mangaflow.feature.home_screen.navigation.homeScreen
import com.example.mangaflow.feature.home_screen.screen.MangaScreenVM
import com.example.mangaflow.feature.profile_screen.navigation.profileScreen
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    KoinContext {
        //Declare values here to don't fetch mangaLists multiple times
        val mangaScreenVM = koinViewModel<MangaScreenVM>()

        val showNavRail = showNavRail()
        NavHost(
            startDestination = HomeScreenRoute,
            navController = navController
        ) {
            homeScreen(
                navController = navController,
                mangaScreenVM = mangaScreenVM,
                showNavRail = showNavRail
            )

            bookmarksScreen(
                navController = navController,
                showNavRail = showNavRail
            )

            profileScreen(
                navController = navController,
                showNavRail = showNavRail
            )
        }
    }
}