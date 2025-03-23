package com.example.mangaflow.feature.auth_screen.sections.large_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.icons.MangaFlowIcons
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mTypography
import org.jetbrains.compose.resources.painterResource

@Composable
fun ColumnScope.AppTitleLargeScreenSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.align(Alignment.CenterHorizontally)
    ) {
        Icon(
            painter = painterResource(MangaFlowIcons.YinYangMulticolor),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(48.dp)
        )

        Column {
            Text(
                text = "MangaFlow",
                style = mTypography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Powered by MangaDex",
                style = mTypography.labelSmall.copy(
                    color = mColors.tertiary
                ),
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}