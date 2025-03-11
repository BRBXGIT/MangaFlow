package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography
import com.example.mangaflow.feature.manga_details_screen.sections.common.MangaLink

@Composable
fun CompactScreensMangaLinksLRSection(
    links: List<MangaLink>,
    onLinkClick: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(links) { mangaLink ->
            Box(
                modifier = Modifier
                    .clip(mShapes.extraSmall)
                    .background(mColors.secondaryContainer)
                    .clickable {
                        onLinkClick(mangaLink.link)
                    }
                    .padding(4.dp)
            ) {
                Text(
                    text = mangaLink.name,
                    style = mTypography.labelLarge
                )
            }
        }
    }
}