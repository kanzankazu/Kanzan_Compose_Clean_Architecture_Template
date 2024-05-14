package com.kanzankazu.composecleanarchitecture.data.di

import com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.source.app.AppPreferencesSource
import com.kanzankazu.composecleanarchitecture.data.datasource.remote.source.user.UserDataSource
import com.kanzankazu.composecleanarchitecture.data.repository.preference.AppPreferenceRepository
import com.kanzankazu.composecleanarchitecture.data.repository.preference.AppPreferenceRepositoryImpl
import com.kanzankazu.composecleanarchitecture.data.repository.user.UserRepository
import com.kanzankazu.composecleanarchitecture.data.repository.user.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        userDataSource: UserDataSource,
    ): UserRepository = UserRepositoryImpl(userDataSource)

    @Singleton
    @Provides
    fun provideAppPreferenceRepository(
        appPreferencesSource: AppPreferencesSource,
    ): AppPreferenceRepository = AppPreferenceRepositoryImpl(appPreferencesSource)
}