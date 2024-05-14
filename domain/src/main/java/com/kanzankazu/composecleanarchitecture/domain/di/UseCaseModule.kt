package com.kanzankazu.composecleanarchitecture.domain.di

import com.kanzankazu.composecleanarchitecture.common.di.IoDispatcher
import com.kanzankazu.composecleanarchitecture.domain.mapper.user.GithubUsersSearchDomainModelMapper
import com.kanzankazu.composecleanarchitecture.data.repository.user.UserRepository
import com.kanzankazu.composecleanarchitecture.domain.usecase.user.UserUseCaseImpl
import com.kanzankazu.composecleanarchitecture.domain.usecase.user.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideHomeUseCase(
        getUserRepository: UserRepository,
        githubUsersSearchDomainModelMapper: GithubUsersSearchDomainModelMapper,
        @IoDispatcher dispatcher: CoroutineDispatcher,
    ): UserUseCase = UserUseCaseImpl(
        dispatcher,
        getUserRepository,
        githubUsersSearchDomainModelMapper
    )
}