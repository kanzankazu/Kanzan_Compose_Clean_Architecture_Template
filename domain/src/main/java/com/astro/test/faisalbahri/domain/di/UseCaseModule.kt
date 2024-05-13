package com.astro.test.faisalbahri.domain.di

import com.astro.test.faisalbahri.common.di.IoDispatcher
import com.astro.test.faisalbahri.domain.mapper.user.GithubUsersSearchDomainModelMapper
import com.astro.test.faisalbahri.data.repository.user.UserRepository
import com.astro.test.faisalbahri.domain.usecase.user.UserUseCaseImpl
import com.astro.test.faisalbahri.domain.usecase.user.UserUseCase
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