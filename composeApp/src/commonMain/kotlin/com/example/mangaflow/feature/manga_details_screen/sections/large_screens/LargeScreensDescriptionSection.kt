package com.example.mangaflow.feature.manga_details_screen.sections.large_screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mTypography

@Composable
fun LargeScreensDescriptionSection(
    description: String
) {
    Text(
        text = AnnotatedString.fromHtml(description),
        style = mTypography.bodyMedium,
        modifier = Modifier.padding(horizontal = 68.dp)
    )
}