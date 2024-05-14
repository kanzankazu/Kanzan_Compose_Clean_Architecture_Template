package com.kanzankazu.composecleanarchitecture.data.di

import com.kanzankazu.composecleanarchitecture.data.datasource.remote.api.UserApi
import com.kanzankazu.composecleanarchitecture.data.datasource.remote.source.user.UserDataSource
import com.kanzankazu.composecleanarchitecture.data.datasource.remote.source.user.UserDataSourceImpl
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
    fun provideUserDataSource(userApi: UserApi): UserDataSource = UserDataSourceImpl(userApi)
}