package com.example.mangaflow.feature.auth_screen.sections.compact_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.custom_modifiers.noRippleClickable
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography

@Composable
fun ColumnScope.NewUserCompactScreensSection() {
    Box(
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .background(
                color = mColors.surfaceContainerHighest,
                shape = mShapes.small
            )
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Text(
                text = "New user? ",
                style = mTypography.labelLarge
            )

            Text(
                text = "Register",
                style = mTypography.labelLarge.copy(
                    color = mColors.primary,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .clip(mShapes.small)
                    .noRippleClickable {  }
            )
        }
    }
}