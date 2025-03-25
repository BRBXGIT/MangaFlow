package com.example.mangaflow.feature.auth_screen.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mangaflow.core.design_system.snackbars.ObserveAsEvents
import com.example.mangaflow.core.design_system.snackbars.SnackbarController
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.feature.auth_screen.screen.compact_screens.AuthCompactScreens
import com.example.mangaflow.feature.auth_screen.screen.large_screens.AuthLargeScreens
import com.example.mangaflow.feature.home_screen.navigation.HomeScreenRoute
import kotlinx.coroutines.launch

@Composable
fun AuthScreen(
    viewModel: AuthScreenVM,
    bigScreen: Boolean,
    navController: NavController
) {
    //Snackbars stuff
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    ObserveAsEvents(flow = SnackbarController.events, snackbarHostState) { event ->
        scope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()

            val result = snackbarHostState.showSnackbar(
                message = event.message,
                actionLabel = event.action?.name,
                duration = SnackbarDuration.Indefinite,
                withDismissAction = true
            )

            if(result == SnackbarResult.ActionPerformed) {
                event.action?.action?.invoke()
            }
        }
    }

    val success by viewModel.success.collectAsStateWithLifecycle()
    LaunchedEffect(success) {
        if(success) {
            navController.navigate(HomeScreenRoute)
        }
    }
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
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
                    )
                }
            )
        }
    }
}