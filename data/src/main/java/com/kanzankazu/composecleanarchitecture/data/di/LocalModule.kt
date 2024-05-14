package com.kanzankazu.composecleanarchitecture.data.di

import com.kanzankazu.composecleanarchitecture.common.utils.ContextProvider
import com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.preference.EncryptedPreferencesImpl
import com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.preference.EncryptedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LocalModule {

    @Provides
    @Singleton
    fun provideEncryptedPreferences(
        contextProvider: ContextProvider,
    ): EncryptedPreferences {
        return EncryptedPreferencesImpl(
            contextProvider.getContext(),
            ""/*"${BuildConfig.APPLICATION_ID}.secure_preferences"*/
        )
    }
}