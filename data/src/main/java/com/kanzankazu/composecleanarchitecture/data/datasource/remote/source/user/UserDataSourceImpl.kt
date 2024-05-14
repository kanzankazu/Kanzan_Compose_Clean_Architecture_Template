package com.kanzankazu.composecleanarchitecture.data.datasource.remote.source.user

import com.kanzankazu.composecleanarchitecture.data.datasource.remote.api.UserApi
import com.kanzankazu.composecleanarchitecture.data.model.user.GithubUsersSearchData
import retrofit2.Response
import javax.inject.Inject

internal class UserDataSourceImpl @Inject constructor(
    private val userApi: UserApi,
) : UserDataSource {
    override suspend fun getSearchUser(q: String): Response<GithubUsersSearchData> {
        return userApi.getSearchUser(q)
    }
}