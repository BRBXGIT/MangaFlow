package com.example.mangaflow.core.design_system.cards

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.size.Size

@Composable
actual fun MangaFlowAsyncImage(
    index: Int,
    coverImageUrl: String
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(coverImageUrl)
            .crossfade(500)
            .size(Size.ORIGINAL)
            .build(),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        filterQuality = FilterQuality.Low,
        contentScale = ContentScale.Crop,
        loading = { if(index <= 6) AnimatedShimmer(100.dp, 130.dp) }
    )
}