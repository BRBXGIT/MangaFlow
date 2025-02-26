package com.example.mangaflow.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.mangaflow.di.initKoin

fun main() {
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