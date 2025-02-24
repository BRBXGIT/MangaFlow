package com.example.mangaflow

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.mangaflow.app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MangaFlow",
    ) {
        App()
    }
}