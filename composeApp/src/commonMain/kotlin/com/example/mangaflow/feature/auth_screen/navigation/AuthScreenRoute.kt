package com.example.mangaflow.feature.auth_screen.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mangaflow.feature.auth_screen.screen.AuthScreen
import com.example.mangaflow.feature.auth_screen.screen.AuthScreenVM
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
data object AuthScreenRoute

@OptIn(KoinExperimentalAPI::class)
fun NavGraphBuilder.authScreen() = composable<AuthScreenRoute> {
    val authScreenVM = koinViewModel<AuthScreenVM>()

    AuthScreen(
        viewModel = authScreenVM
    )
}