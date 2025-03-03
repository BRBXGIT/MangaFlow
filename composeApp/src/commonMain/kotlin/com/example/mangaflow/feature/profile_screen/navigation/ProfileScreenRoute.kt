package com.example.mangaflow.feature.profile_screen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mangaflow.feature.profile_screen.screen.ProfileScreen
import kotlinx.serialization.Serializable

@Serializable
data object ProfileScreenRoute

fun NavGraphBuilder.profileScreen(
    navController: NavController,
    showNavRail: Boolean
) = composable<ProfileScreenRoute> {
    ProfileScreen(
        navController = navController,
        showNavRail = showNavRail
    )
}