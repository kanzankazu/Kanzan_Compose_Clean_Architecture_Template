package com.astro.test.faisalbahri.domain.usecase.user

import com.astro.test.faisalbahri.common.di.IoDispatcher
import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.domain.mapper.user.GithubUsersSearchDomainModelMapper
import com.astro.test.faisalbahri.data.repository.user.UserRepository
import com.astro.test.faisalbahri.domain.model.GithubUsersSearch
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
