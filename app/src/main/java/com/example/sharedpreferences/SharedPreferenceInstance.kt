package com.example.sharedpreferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


object SharedPreferenceInstance {

    private val APP_PREF = "APP_PREF"
    private lateinit var preferences: SharedPreferences


    fun init(context: Context) {
        preferences =  context.getSharedPreferences(APP_PREF, MODE_PRIVATE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    fun getStringValue(preference: String): String? {
        return preferences.getString(preference, null)
    }

    fun setStringValue(newValue: String, preference: String) {
        preferences.edit{
            it.putString(preference, newValue)
        }
    }

    fun clearAll(){
        preferences.edit().clear().apply()
    }
    fun remove(preference: String){
        preferences.edit().remove(preference).apply()
    }
}

