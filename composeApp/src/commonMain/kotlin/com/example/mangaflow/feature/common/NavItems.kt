package com.example.mangaflow.feature.common

import com.example.mangaflow.core.design_system.icons.MangaFlowIcons
import com.example.mangaflow.feature.bookmarks_screen.navigation.BookmarksScreenRoute
import com.example.mangaflow.feature.home_screen.navigation.HomeScreenRoute
import com.example.mangaflow.feature.profile_screen.navigation.ProfileScreenRoute
import org.jetbrains.compose.resources.DrawableResource

data class NavItem(
    val label: String,
    val iconDefault: DrawableResource,
    val iconChosen: DrawableResource,
    val route: String,
    val destination: Any
)

val navItems = listOf(
    NavItem(
        label = "Home",
        iconDefault = MangaFlowIcons.Home,
        iconChosen = MangaFlowIcons.HomeFilled,
        route = "HomeScreenRoute",
        destination = HomeScreenRoute
    ),
    NavItem(
        label = "Bookmarks",
        iconDefault = MangaFlowIcons.Bookmark,
        iconChosen = MangaFlowIcons.BookmarkFilled,
        route = "BookmarksScreenRoute",
        destination = BookmarksScreenRoute
    ),
    NavItem(
        label = "Profile",
        iconDefault = MangaFlowIcons.User,
        iconChosen = MangaFlowIcons.UserFilled,
        route = "ProfileScreenRoute",
        destination = ProfileScreenRoute
    )
)
