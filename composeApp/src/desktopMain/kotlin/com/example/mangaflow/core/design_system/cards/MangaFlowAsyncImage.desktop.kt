package com.example.mangaflow.core.design_system.cards

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import coil3.PlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.size.Size

@Composable
actual fun MangaFlowAsyncImage(
    index: Int?,
    height: Dp,
    width: Dp,
    coverImageUrl: String,
    modifier: Modifier
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(PlatformContext.INSTANCE)
            .data(coverImageUrl)
            .crossfade(500)
            .size(Size.ORIGINAL)
            .build(),
        contentDescription = null,
        modifier = modifier.fillMaxSize(),
        filterQuality = FilterQuality.Low,
        contentScale = ContentScale.Crop,
        loading = {
            if(index != null) {
                if(index <= 6) AnimatedShimmer(width, height)
            }
        }
    )
}