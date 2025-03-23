package com.example.mangaflow.feature.bookmarks_screen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mangaflow.feature.bookmarks_screen.screen.BookmarksScreen
import kotlinx.serialization.Serializable

@Serializable
data object BookmarksScreenRoute

fun NavGraphBuilder.bookmarksScreen(
    navController: NavController,
    bigScreen: Boolean
) = composable<BookmarksScreenRoute> {
    BookmarksScreen(
        navController = navController,
        bigScreen = bigScreen
    )
}