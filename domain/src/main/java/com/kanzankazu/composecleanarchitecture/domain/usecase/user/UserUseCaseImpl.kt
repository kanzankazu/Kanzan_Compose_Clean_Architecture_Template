package com.kanzankazu.composecleanarchitecture.domain.usecase.user

import com.kanzankazu.composecleanarchitecture.common.di.IoDispatcher
import com.kanzankazu.composecleanarchitecture.common.utils.Resource
import com.kanzankazu.composecleanarchitecture.domain.mapper.user.GithubUsersSearchDomainModelMapper
import com.kanzankazu.composecleanarchitecture.data.repository.user.UserRepository
import com.kanzankazu.composecleanarchitecture.domain.model.GithubUsersSearch
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val getUserRepository: UserRepository,
    private val githubUsersSearchDomainModelMapper: GithubUsersSearchDomainModelMapper,
) : UserUseCase {
    override suspend operator fun invoke(q: String): Resource<GithubUsersSearch> {
        return withContext(dispatcher) {
            when (val responseResource = getUserRepository.getSearchUser(q)) {
                is Resource.Success -> Resource.Success(githubUsersSearchDomainModelMapper.mapToDomainModel(responseResource.data))
                is Resource.Failure -> Resource.Failure(responseResource.error)
            }
        }
    }
}
