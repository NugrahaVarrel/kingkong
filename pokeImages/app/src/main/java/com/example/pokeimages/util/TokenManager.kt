package com.example.pokeimages.util

import android.content.Context

object TokenManager {

    private const val PREF_NAME = "USER_PREF"
    private const val KEY_TOKENS = "TOKEN_AUTH"

    private val token:String?=""

    fun saveToken(context: Context, token: String) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val tokens = getTokens(context).toMutableList()
        tokens.add(token)
        prefs.edit().putStringSet(KEY_TOKENS, tokens.toSet()).apply()
    }

    fun getTokens(context: Context): List<String> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getStringSet(KEY_TOKENS, emptySet())?.toList() ?: emptyList()
    }

    fun clearTokens(context: Context) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().remove(KEY_TOKENS).apply()
    }

    fun getToken(): String? = token
}