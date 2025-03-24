package com.example.mangaflow.feature.auth_screen.screen.large_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.feature.auth_screen.sections.common.AppTitleSection
import com.example.mangaflow.feature.auth_screen.sections.large_screens.AuthBlockLargeScreensSection

@Composable
fun AuthLargeScreens(
    onAuthenticateClick: (userName: String, password: String) -> Unit,
    innerPadding: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            AppTitleSection()

            AuthBlockLargeScreensSection(
                onAuthenticateClick = { userName, password ->
                    onAuthenticateClick(userName, password)
                }
            )
        }
    }
}