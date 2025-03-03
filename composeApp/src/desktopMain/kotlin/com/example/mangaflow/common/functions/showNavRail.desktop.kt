@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package com.example.mangaflow.common.functions

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

@Composable
actual fun showNavRail(): Boolean {
    val windowSize = calculateWindowSizeClass()
    val showNavRail = windowSize.widthSizeClass != WindowWidthSizeClass.Compact

    return showNavRail
}