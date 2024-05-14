package com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.source.app

import com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.preference.EncryptedPreferences
import com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.source.ConstantPreference
import javax.inject.Inject

class AppPreferencesSourceImpl @Inject constructor(
    private val encryptedPreferences: EncryptedPreferences,
) : AppPreferencesSource {
    override var flavour: String
        get() = encryptedPreferences.getString(ConstantPreference.KEY_FLAVOUR, "")
        set(value) = encryptedPreferences.setString(ConstantPreference.KEY_FLAVOUR, value)
}
