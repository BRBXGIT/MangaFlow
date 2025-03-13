package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.cards.MangaFlowAsyncImage
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource

@Composable
fun CompactScreensHeader(
    coverImageUrl: String,
    titleEng: String,
    titleJap: String,
    authors: String,
    topPadding: Dp
) {
    val hazeState = remember { HazeState() }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp + topPadding)
        ) {
            MangaFlowAsyncImage(
                height = 0.dp,
                width = 0.dp,
                coverImageUrl = coverImageUrl,
                modifier = Modifier.hazeSource(hazeState)
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .hazeEffect(
                        state = hazeState,
                        style = HazeStyle(
                            backgroundColor = mColors.background,
                            blurRadius = 8.dp,
                            tint = HazeTint(
                                color = mColors.background.copy(alpha = 0.5f),
                                blendMode = BlendMode.SrcOver
                            )
                        )
                    ),
                contentAlignment = Alignment.BottomCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7f)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    mColors.background
                                )
                            )
                        )
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp + topPadding) //Same as the image height to create a bottom hit-box
                    .padding(
                        top = topPadding,
                        start = 16.dp,
                        end = 16.dp
                    )
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp, 160.dp)
                        .clip(mShapes.small),
                    contentAlignment = Alignment.Center
                ) {
                    MangaFlowAsyncImage(
                        index = 0,
                        height = 130.dp + topPadding,
                        width = 100.dp,
                        coverImageUrl = coverImageUrl
                    )
                }

                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(
                            text = titleEng,
                            style = mTypography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = if(titleEng == "No title provided :0") mColors.error else mColors.onBackground
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Text(
                            text = titleJap,
                            style = mTypography.titleSmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Text(
                        text = authors,
                        style = mTypography.titleSmall
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) { //TODO find where column takes arrangement spacedBy
            Button(
                onClick = {  },
                shape = mShapes.extraSmall,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Add to library",
                    style = mTypography.bodyLarge
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {  },
                    shape = mShapes.extraSmall,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = mColors.primaryContainer,
                        contentColor = mColors.onPrimaryContainer
                    ),
                    modifier = Modifier.weight(0.5f)
                ) {
                    Text(
                        text = "Add to MDList",
                        style = mTypography.bodyLarge
                    )
                }

                Button(
                    onClick = {  },
                    shape = mShapes.extraSmall,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = mColors.primaryContainer,
                        contentColor = mColors.onPrimaryContainer
                    ),
                    modifier = Modifier.weight(0.5f)
                ) {
                    Text(
                        text = "Start reading",
                        style = mTypography.bodyLarge
                    )
                }
            }
        }
    }
}