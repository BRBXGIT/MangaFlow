package com.example.mangaflow.feature.auth_screen.screen.compact_screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AuthCompactScreens(
    onAuthenticateClick: () -> Unit
) {
    Button(
        onClick = { onAuthenticateClick() }
    ) {
        Text("Authentication")
    }
}