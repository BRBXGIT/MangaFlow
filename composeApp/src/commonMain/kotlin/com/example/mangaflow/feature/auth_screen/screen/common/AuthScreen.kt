package com.example.mangaflow.feature.auth_screen.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.feature.auth_screen.screen.compact_screens.AuthCompactScreens
import com.example.mangaflow.feature.auth_screen.screen.large_screens.AuthLargeScreens
import com.example.mangaflow.feature.home_screen.navigation.HomeScreenRoute

@Composable
fun AuthScreen(
    viewModel: AuthScreenVM,
    bigScreen: Boolean,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
    ) { innerPadding ->
        if(bigScreen) {
            AuthLargeScreens(
                innerPadding = innerPadding,
                onAuthenticateClick = { userName, password ->
                    viewModel.fetchUserAccessToken(
                        userName = userName,
                        password = password,
                        onSuccess = { navController.navigate(HomeScreenRoute) }
                    )
                }
            )
        } else {
            AuthCompactScreens(
                innerPadding = innerPadding,
                onAuthenticateClick = { userName, password ->
                    viewModel.fetchUserAccessToken(
                        userName = userName,
                        password = password,
                        onSuccess = { navController.navigate(HomeScreenRoute) }
                    )
                }
            )
        }
    }
}