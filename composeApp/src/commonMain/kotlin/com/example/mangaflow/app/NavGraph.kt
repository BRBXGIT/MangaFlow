package com.example.mangaflow.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mangaflow.common.functions.showNavRail
import com.example.mangaflow.feature.auth_screen.navigation.AuthScreenRoute
import com.example.mangaflow.feature.auth_screen.navigation.authScreen
import com.example.mangaflow.feature.bookmarks_screen.navigation.bookmarksScreen
import com.example.mangaflow.feature.home_screen.navigation.homeScreen
import com.example.mangaflow.feature.home_screen.screen.HomeScreenVM
import com.example.mangaflow.feature.manga_details_screen.navigation.mangaDetailsScreen
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
        val homeScreenVM = koinViewModel<HomeScreenVM>()

        val showNavRail = showNavRail()
        NavHost(
            startDestination = AuthScreenRoute,
            navController = navController
        ) {
            homeScreen(
                navController = navController,
                homeScreenVM = homeScreenVM,
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

            mangaDetailsScreen(
                navController = navController,
                showNavRail = showNavRail
            )

            authScreen()
        }
    }
}