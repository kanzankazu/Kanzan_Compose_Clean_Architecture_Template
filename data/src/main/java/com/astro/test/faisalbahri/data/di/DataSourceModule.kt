package com.astro.test.faisalbahri.data.di

import com.astro.test.faisalbahri.data.datasource.remote.api.user.Api
import com.astro.test.faisalbahri.data.datasource.remote.source.user.UserDataSource
import com.astro.test.faisalbahri.data.datasource.remote.source.user.UserDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideUserDataSource(api: Api): UserDataSource = UserDataSourceImpl(api)
}