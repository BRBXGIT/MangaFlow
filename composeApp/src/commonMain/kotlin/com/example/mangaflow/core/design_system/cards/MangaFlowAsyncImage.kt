package com.example.mangaflow.core.design_system.cards

import androidx.compose.runtime.Composable

@Composable
expect fun MangaFlowAsyncImage(
    index: Int,
    coverImageUrl: String
)