package com.example.mangaflow.feature.manga_screen.sections

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
expect fun MangaScreenTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    loadingState: Boolean
)