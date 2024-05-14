package com.kanzankazu.composecleanarchitecture.data.di

import com.kanzankazu.composecleanarchitecture.data.datasource.remote.api.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkApiModule {
    @Singleton
    @Provides
    fun provideUserApi(
        retrofit: Retrofit,
    ): UserApi = retrofit.create(UserApi::class.java)
}