package com.example.mangaflow.feature.manga_details_screen.sections.large_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.cards.MangaFlowAsyncImage
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography

@Composable
fun LargeScreensHeader(
    coverImageUrl: String,
    titleEng: String,
    titleJap: String,
    author: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) //Same as the image height to create a bottom hit-box
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
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = titleJap,
                    style = mTypography.titleSmall
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = author,
                    style = mTypography.titleSmall
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {  },
                        shape = mShapes.extraSmall
                    ) {
                        Text(
                            text = "Add to library",
                            style = mTypography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    Button(
                        onClick = {  },
                        shape = mShapes.extraSmall,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = mColors.primaryContainer,
                            contentColor = mColors.onPrimaryContainer
                        )
                    ) {
                        Text(
                            text = "Start reading",
                            style = mTypography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    }
}