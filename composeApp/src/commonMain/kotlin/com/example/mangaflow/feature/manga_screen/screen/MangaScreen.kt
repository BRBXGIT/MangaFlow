package com.example.mangaflow.feature.manga_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mangaflow.core.design_system.theme.mColors

@Composable
fun MangaScreen(
    viewModel: MangaScreenVM
) {
    viewModel.fetchAllManga()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val state = rememberLazyListState()
            LaunchedEffect(state) {
                snapshotFlow { state.canScrollForward }
                    .collect { canScrollForward ->
                        if (!canScrollForward) {
                            viewModel.fetchAllManga()
                        }
                    }
            }

            val allManga = viewModel.allManga.collectAsStateWithLifecycle().value
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                state = state
            ) {
                items(allManga) { manga ->
                    Text(
                        text = manga.id
                    )
                }
            }
        }
    }
}