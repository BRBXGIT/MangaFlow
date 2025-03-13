package com.example.mangaflow.feature.manga_details_screen.sections.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.mangaflow.core.design_system.icons.MangaFlowIcons
import com.example.mangaflow.core.design_system.theme.mColors
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MangaDetailsScreenTopBar(
    mangaTitle: String?,
    mangaLoadingState: Boolean,
    scrollBehavior: TopAppBarScrollBehavior,
    onNavIconClick: () -> Unit
) {
    var title by rememberSaveable { mutableStateOf("Loading...") }
    LaunchedEffect(mangaTitle) {
        if(mangaTitle != null) {
            title = mangaTitle
        }
    }

    Column {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = mColors.surfaceContainer.copy(alpha = 0f)
            ),
            scrollBehavior = scrollBehavior,
            title = {
                AnimatedVisibility(
                    visible = scrollBehavior.state.contentOffset <= -600f,
                    enter = fadeIn(tween(300)),
                    exit = fadeOut(tween(300))
                ) {
                    Text(
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = if(title == "No title provided :0") mColors.error else mColors.onBackground
                    )
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = { onNavIconClick() },
                ) {
                    Icon(
                        painter = painterResource(MangaFlowIcons.NavigationArrowLeftFilled),
                        contentDescription = null
                    )
                }
            }
        )

        AnimatedVisibility(
            visible = mangaLoadingState,
            enter = fadeIn(tween(300)) + expandVertically(tween(300)),
            exit = fadeOut(tween(300)) + shrinkVertically(tween(300))
        ) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
    }
}