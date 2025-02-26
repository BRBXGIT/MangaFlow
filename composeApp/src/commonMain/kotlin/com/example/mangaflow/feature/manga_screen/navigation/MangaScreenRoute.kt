package com.example.mangaflow.feature.manga_screen.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mangaflow.feature.manga_screen.screen.MangaScreen
import com.example.mangaflow.feature.manga_screen.screen.MangaScreenVM
import kotlinx.serialization.Serializable

@Serializable
object MangaScreenRoute

fun NavGraphBuilder.mangaScreen(
    mangaScreenVM: MangaScreenVM
) = composable<MangaScreenRoute> {
    MangaScreen(mangaScreenVM)
}