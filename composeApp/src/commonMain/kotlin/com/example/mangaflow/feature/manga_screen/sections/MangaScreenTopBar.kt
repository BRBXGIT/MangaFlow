package com.example.mangaflow.feature.manga_screen.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mangaflow.core.design_system.icons.MangaFlowIcons
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MangaScreenTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    loadingState: Boolean
) {
    Column {
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
}