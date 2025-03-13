package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography
import com.example.mangaflow.feature.manga_details_screen.sections.common.MangaLink

@Composable
fun CompactScreensMangaAdditionalInfoSection(
    genres: List<String>,
    readOrBuyLinks: List<MangaLink>,
    trackLinks: List<MangaLink>,
    altTitles: List<Pair<String, String?>>,
    onLinkClick: (String) -> Unit
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val animatedVerticalPadding by animateDpAsState(
        targetValue = if(expanded) 16.dp else 0.dp,
        animationSpec = tween(300)
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(
                color = mColors.surfaceContainerHigh,
                shape = mShapes.small
            )
            .padding(vertical = animatedVerticalPadding)
            .animateContentSize(animationSpec = tween(300))
    ) {
        TextButton(
            onClick = { expanded = !expanded },
            shape = mShapes.small,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = if(expanded)"Hide additional info" else "Show additional info",
                style = mTypography.bodyLarge
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn(tween(300)),
            exit = fadeOut(tween(0))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Genres: ",
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    CompactScreensMangaGenresLRSection(genres)
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Read or Buy: ",
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    CompactScreensMangaLinksLRSection(
                        links = readOrBuyLinks,
                        onLinkClick = { onLinkClick(it) }
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Track: ",
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    CompactScreensMangaLinksLRSection(
                        links = trackLinks,
                        onLinkClick = { onLinkClick(it) }
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Text(
                        text = "Alt titles: ",
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                    ) {
                        altTitles.forEach { altTitle ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = altTitle.first.uppercase(),
                                    style = mTypography.bodyLarge
                                )

                                Text(
                                    text = altTitle.second.toString(),
                                    style = mTypography.bodyLarge
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}