package com.example.mangaflow.feature.manga_details_screen.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
expect fun MangaDetailsScreen(
    navController: NavController,
    showNavRail: Boolean,
    viewModel: MangaDetailsScreenVM,
    mangaId: String
)