package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.custom_modifiers.noRippleClickable
import com.example.mangaflow.core.design_system.icons.MangaFlowIcons
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mTypography
import org.jetbrains.compose.resources.painterResource

@Composable
fun CompactScreensDescriptionSection(
    description: String
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .animateContentSize()
    ) {
        val animatedColor by animateColorAsState(
            targetValue = if(expanded) mColors.onBackground else mColors.background,
            label = "Animated color"
        )
        if(!expanded) {
            Text(
                text = AnnotatedString.fromHtml(description),
                style = mTypography.bodyMedium.copy(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            mColors.onBackground,
                            animatedColor
                        )
                    )
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        } else {
            Text(
                text = AnnotatedString.fromHtml(description),
                style = mTypography.bodyMedium
            )
        }

        val scaleY by animateFloatAsState(
            targetValue = if(expanded) 1f else -1f,
            label = "Animation for icon"
        )
        Icon(
            painter = painterResource(MangaFlowIcons.ArrowUpFilled),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .graphicsLayer(scaleY = scaleY)
                .noRippleClickable { expanded = !expanded }
        )
    }
}