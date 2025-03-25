package com.example.mangaflow.feature.auth_screen.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.feature.auth_screen.screen.compact_screens.AuthCompactScreens
import com.example.mangaflow.feature.auth_screen.screen.large_screens.AuthLargeScreens

@Composable
fun AuthScreen(
    viewModel: AuthScreenVM,
    bigScreen: Boolean
) {
    val mangaFlowUser by viewModel.mangaFlowUser.collectAsStateWithLifecycle()
    LaunchedEffect(mangaFlowUser) {
        if(!mangaFlowUser.isNullOrEmpty()) {
            viewModel.setIsAuthenticatedKey(true)
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
    ) { innerPadding ->
        if(bigScreen) {
            AuthLargeScreens(
                innerPadding = innerPadding,
                onAuthenticateClick = { userName, password ->
                    viewModel.fetchUserAccessToken(userName, password)
                }
            )
        } else {
            AuthCompactScreens(
                innerPadding = innerPadding,
                onAuthenticateClick = { userName, password ->  
                    
                }
            )
        }
    }
}