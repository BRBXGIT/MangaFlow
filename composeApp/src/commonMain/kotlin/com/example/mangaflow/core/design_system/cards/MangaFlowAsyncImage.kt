package com.example.mangaflow.core.design_system.cards

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

@Composable
expect fun MangaFlowAsyncImage(
    index: Int? = null,
    height: Dp,
    width: Dp,
    coverImageUrl: String,
)