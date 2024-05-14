package com.kanzankazu.composecleanarchitecture.data.di

import com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.preference.EncryptedPreferences
import com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.source.app.AppPreferencesSource
import com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.source.app.AppPreferencesSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LocalApiModule {

    @Provides
    @Singleton
    fun provideEncryptedPreferences(
        encryptedPreferences: EncryptedPreferences,
    ): AppPreferencesSource {
        return AppPreferencesSourceImpl(encryptedPreferences)
    }
}