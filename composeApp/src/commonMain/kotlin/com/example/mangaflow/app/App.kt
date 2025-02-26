package com.example.mangaflow.app

import androidx.compose.runtime.Composable
import com.example.mangaflow.core.design_system.theme.MangaFlowTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MangaFlowTheme {
        NavGraph()
    }
}