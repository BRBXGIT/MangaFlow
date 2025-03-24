package com.example.mangaflow.feature.auth_screen.screen.compact_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.feature.auth_screen.sections.common.AppTitleSection
import com.example.mangaflow.feature.auth_screen.sections.compact_screens.AuthBlockCompactScreensSection
import com.example.mangaflow.feature.auth_screen.sections.compact_screens.NewUserCompactScreensSection

@Composable
fun AuthCompactScreens(
    onAuthenticateClick: (userName: String, password: String) -> Unit,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = innerPadding.calculateBottomPadding() + 32.dp,
                top = innerPadding.calculateTopPadding() + 32.dp,
                start = 16.dp,
                end = 16.dp
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            AppTitleSection()

            AuthBlockCompactScreensSection(onAuthenticateClick)
        }

        NewUserCompactScreensSection()
    }
}