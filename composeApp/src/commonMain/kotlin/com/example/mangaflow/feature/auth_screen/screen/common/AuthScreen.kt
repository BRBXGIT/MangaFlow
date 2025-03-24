package com.example.mangaflow.feature.auth_screen.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.feature.auth_screen.screen.compact_screens.AuthCompactScreens
import com.example.mangaflow.feature.auth_screen.screen.large_screens.AuthLargeScreens

@Composable
fun AuthScreen(
    viewModel: AuthScreenVM,
    bigScreen: Boolean
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
    ) { innerPadding ->
        if(bigScreen) {
            AuthLargeScreens(
                innerPadding = innerPadding,
                onAuthenticateClick = {  }
            )
        } else {
            AuthCompactScreens(
                onAuthenticateClick = {
                    viewModel.fetchUserAccessToken("BRBX", "dt2005mm")
                }
            )
        }
    }
}