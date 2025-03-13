package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography

@Composable
fun MangaChapterItem(
    volume: String,
    chapter: String,
    title: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(
                color = mColors.surfaceContainerHigh,
                shape = mShapes.small
            )
            .padding(8.dp, 8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = title,
                style = mTypography.bodyLarge.copy(
                    color = if(title == "No title provided :0") mColors.error else mColors.primary
                )
            )

            Text(
                text = "Volume $volume. Chapter: $chapter",
                style = mTypography.bodyMedium
            )
        }
    }
}