package com.example.mangaflow.core.data.local.shared_prefs

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import java.util.prefs.Preferences

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SettingsProvider {
    actual fun provideSettings(): Settings {
        val delegate = Preferences.userRoot()
        return PreferencesSettings(delegate)
    }
}