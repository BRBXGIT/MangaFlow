package com.example.mangaflow.core.design_system.cards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MangaCard(
    index: Int,
    coverImageUrl: String,
    title: String,
    genres: String,
    onCardClick: () -> Unit
) {
    Card(
        shape = mShapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .clip(mShapes.small)
            .combinedClickable(
                onClick = { onCardClick() },
                onLongClick = {  }
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = mColors.surfaceVariant,
                    shape = mShapes.small
                )
        ) {
            MangaFlowAsyncImage(
                index = index,
                coverImageUrl = coverImageUrl,
                height = 130.dp,
                width = 100.dp
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(mColors.secondaryContainer)
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = mTypography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = if(title == "No title provided :0") mColors.error else mColors.onSecondaryContainer
                    )
                )


                Text(
                    text = genres,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = mTypography.bodySmall.copy(
                        color = mColors.secondary
                    )
                )
            }
        }
    }
}