package com.astro.test.faisalbahri.data.repository.user

import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.data.extensions.handleAPICall
import com.astro.test.faisalbahri.data.model.user.GithubUsersSearchResponse
import com.astro.test.faisalbahri.data.datasource.remote.source.user.UserDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource,
) : UserRepository {
    override suspend fun getSearchUser(q: String): Resource<GithubUsersSearchResponse> =
        handleAPICall { userDataSource.getSearchUser(q) }
}