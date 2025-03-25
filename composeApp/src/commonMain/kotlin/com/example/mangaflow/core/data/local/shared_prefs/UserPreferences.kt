package com.example.mangaflow.core.data.local.shared_prefs

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

class UserPreferences(
    private val settings: Settings
) {

    companion object {
        private const val IS_AUTHENTICATED_KEY = "is_authenticated"
    }

    fun isUserRegistered(): Boolean {
        return settings.getBoolean(IS_AUTHENTICATED_KEY, false)
    }

    fun setUserRegistered(registered: Boolean) {
        settings[IS_AUTHENTICATED_KEY] = registered
    }
}