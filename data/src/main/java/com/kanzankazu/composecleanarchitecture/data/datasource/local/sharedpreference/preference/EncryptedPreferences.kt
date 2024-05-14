package com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.preference

interface EncryptedPreferences {
    fun setBoolean(key: String, value: Boolean)
    fun setInt(key: String, value: Int)
    fun setLong(key: String, value: Long)
    fun setString(key: String, value: String)

    fun getBoolean(key: String, defaultValue: Boolean): Boolean
    fun getInt(key: String, defaultValue: Int): Int
    fun getLong(key: String, defaultValue: Int): Long
    fun getString(key: String): String?
    fun getString(key: String, defaultValue: String): String

    fun remove(key: String)
    fun clear()
}
