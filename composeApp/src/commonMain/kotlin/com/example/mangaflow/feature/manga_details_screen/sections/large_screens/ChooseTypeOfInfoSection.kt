package com.example.mangaflow.feature.manga_details_screen.sections.large_screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography

@Composable
fun ChooseTypeOfInfoSection(
    chosenContentType: ContentType,
    onContentTypeChange: (ContentType) -> Unit,
    mangaChaptersLanguage: String?,
    mangaChaptersTranslationGroupName: String?,
    onLanguageClick:() -> Unit,
    onTranslationClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(
                color = mColors.secondaryContainer,
                shape = mShapes.small
            )
            .padding(8.dp)
    ) {
        ContentType.entries.forEach { contentType ->
            val chosenContentAnimatedColor by animateColorAsState(
                targetValue = if(contentType == chosenContentType) mColors.secondary else Color.Transparent,
                animationSpec = tween(200)
            )

            Box(
                modifier = Modifier
                    .clip(mShapes.small)
                    .background(chosenContentAnimatedColor)
                    .clickable {
                        onContentTypeChange(contentType)
                    }
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = contentType.toString(),
                    style = mTypography.bodyLarge
                )
            }
        }

        AnimatedVisibility(
            visible = chosenContentType == ContentType.Chapters,
            enter = expandHorizontally(tween(300)) + fadeIn(tween(300)),
            exit = shrinkHorizontally(tween(300)) + fadeOut(tween(300))
        ) {
            Box(
                modifier = Modifier
                    .clip(mShapes.small)
                    .clickable { onLanguageClick() }
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = mangaChaptersLanguage ?: "Select language",
                    style = mTypography.bodyLarge
                )
            }
        }

        AnimatedVisibility(
            visible = (chosenContentType == ContentType.Chapters) and (mangaChaptersLanguage != null),
            enter = expandHorizontally(tween(300)) + fadeIn(tween(300)),
            exit = shrinkHorizontally(tween(300)) + fadeOut(tween(300))
        ) {
            Box(
                modifier = Modifier
                    .clip(mShapes.small)
                    .clickable {
                        onTranslationClick()
                    }
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = mangaChaptersTranslationGroupName ?: "Select translation group",
                    style = mTypography.bodyLarge
                )
            }
        }
    }
}

enum class ContentType {
    Info, Chapters
}