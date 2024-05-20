package com.example.mechtatestassignment.util

import android.content.Context
import android.content.SharedPreferences

private const val APP_PREFERENCES = "appPreferences"

class AppPreferences(context: Context) {
    private val preferences: SharedPreferences =
        context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    fun setString(
        key: String,
        value: String
    ) {
        with(preferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(
        key: String
    ): String {
        return preferences.getString(key, "").orEmpty()
    }

    fun setInt(
        key: String,
        value: Int
    ) {
        with(preferences.edit()) {
            putInt(key, value)
            apply()
        }
    }

    fun getInt(
        key: String
    ): Int {
        return preferences.getInt(key, 0)
    }

    fun setBoolean(
        key: String,
        value: Boolean
    ) {
        with(preferences.edit()) {
            putBoolean(key, value)
            apply()
        }
    }

    fun getBoolean(
        key: String,
    ): Boolean {
        return preferences.getBoolean(key, false)
    }
}