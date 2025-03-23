package com.example.mangaflow.feature.profile_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.feature.common.NavBar
import com.example.mangaflow.feature.common.NavRail

@Composable
fun ProfileScreen(
    navController: NavController,
    bigScreen: Boolean
) {
    Scaffold(
        bottomBar = {
            if(!bigScreen) {
                NavBar(navController)
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
    ) {
        Text("Profile crene")
    }

    if(bigScreen) {
        NavRail(navController)
    }
}