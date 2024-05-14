package com.kanzankazu.composecleanarchitecture.data.repository.user

import com.kanzankazu.composecleanarchitecture.common.utils.Resource
import com.kanzankazu.composecleanarchitecture.data.extensions.handleAPICall
import com.kanzankazu.composecleanarchitecture.data.model.user.GithubUsersSearchData
import com.kanzankazu.composecleanarchitecture.data.datasource.remote.source.user.UserDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource,
) : UserRepository {
    override suspend fun getSearchUser(q: String): Resource<GithubUsersSearchData> =
        handleAPICall { userDataSource.getSearchUser(q) }
}