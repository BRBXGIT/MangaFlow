package com.example.mangaflow.feature.manga_screen.sections

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import com.example.mangaflow.core.design_system.icons.MangaFlowIcons
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun MangaScreenTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    loadingState: Boolean
) {
    TopAppBar(
        title = { Text(text = "Manga") },
        scrollBehavior = scrollBehavior,
        actions = {
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    painter = painterResource(MangaFlowIcons.Magnifier),
                    contentDescription = null
                )
            }

            IconButton(
                onClick = {  }
            ) {
                Icon(
                    painter = painterResource(MangaFlowIcons.Settings),
                    contentDescription = null
                )
            }
        }
    )
}