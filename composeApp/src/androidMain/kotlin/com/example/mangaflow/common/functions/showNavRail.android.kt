@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package com.example.mangaflow.common.functions

import android.app.Activity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun showNavRail(): Boolean {
    val context = LocalContext.current
    val activity = context as? Activity ?: return false

    val windowSize = calculateWindowSizeClass(activity)
    val showNavRail = windowSize.widthSizeClass != WindowWidthSizeClass.Compact

    return showNavRail
}