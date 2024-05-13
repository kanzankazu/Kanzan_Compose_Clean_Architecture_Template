package com.astro.test.faisalbahri.data.di

import com.astro.test.faisalbahri.data.datasource.remote.source.user.UserDataSource
import com.astro.test.faisalbahri.data.repository.user.UserRepository
import com.astro.test.faisalbahri.data.repository.user.UserRepositoryImpl
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
    fun provideHomeRepository(
        userDataSource: UserDataSource,
    ): UserRepository = UserRepositoryImpl(userDataSource)
}