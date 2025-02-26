package com.example.mangaflow.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mangaflow.feature.manga_screen.navigation.MangaScreenRoute
import com.example.mangaflow.feature.manga_screen.navigation.mangaScreen
import com.example.mangaflow.feature.manga_screen.screen.MangaScreenVM
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    KoinContext {
        val mangaScreenVM = koinViewModel<MangaScreenVM>()

        NavHost(
            startDestination = MangaScreenRoute,
            navController = navController
        ) {
            mangaScreen(mangaScreenVM)
        }
    }
}