package com.example.mangaflow.feature.manga_details_screen.sections.large_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.cards.MangaFlowAsyncImage
import com.example.mangaflow.core.design_system.theme.mShapes

@Composable
fun LargeScreensHeader(
    coverImageUrl: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(150.dp, 200.dp)
                .clip(mShapes.small),
            contentAlignment = Alignment.Center
        ) {
            MangaFlowAsyncImage(
                index = 0,
                height = 200.dp,
                width = 150.dp,
                coverImageUrl = coverImageUrl
            )
        }
    }
}