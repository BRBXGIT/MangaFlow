package com.example.mangaflow.core.data.local.shared_prefs

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SettingsProvider(
    private val context: Context
) {
    actual fun provideSettings(): Settings {
        val delegate = context.getSharedPreferences("manga_flow_preferences", Context.MODE_PRIVATE)
        return SharedPreferencesSettings(delegate)
    }
}