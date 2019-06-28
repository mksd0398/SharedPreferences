package com.example.sharedpreferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


class SharedPreferenceInstance {

    private val APP_SETTINGS = "APP_SETTINGS"

    private val SOME_STRING_VALUE = "SOME_STRING_VALUE"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(APP_SETTINGS, MODE_PRIVATE)
    }

    fun getSomeStringValue(context: Context): String? {
        return getSharedPreferences(context).getString(SOME_STRING_VALUE, null)
    }

    fun setSomeStringValue(context: Context, newValue: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(SOME_STRING_VALUE, newValue)
        editor.apply()
    }

    fun clear(context: Context) {
        getSharedPreferences(context).edit().clear().apply()
    }

}