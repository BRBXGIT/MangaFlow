package com.example.mangaflow.core.data.local.shared_prefs

import com.russhwolf.settings.Settings

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class SettingsProvider {
    fun provideSettings(): Settings
}