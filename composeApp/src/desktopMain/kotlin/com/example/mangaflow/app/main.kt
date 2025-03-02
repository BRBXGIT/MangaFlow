package com.example.mangaflow.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.mangaflow.di.initKoin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.swing.Swing
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    Dispatchers.setMain(Dispatchers.Swing)

    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "MangaFlow",
        ) {
            App()
        }
    }
}