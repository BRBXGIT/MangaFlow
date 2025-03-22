package com.example.mangaflow.feature.auth_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mangaflow.core.design_system.theme.mColors

@Composable
fun AuthScreen(
    viewModel: AuthScreenVM
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Button(
                onClick = { viewModel.fetchUserAccessToken("BRBX", "dt2005mm") }
            ) {
                Text("Fetch")
            }

            val x by viewModel.accessToken.collectAsStateWithLifecycle()
            Text(x.toString())
        }
    }
}