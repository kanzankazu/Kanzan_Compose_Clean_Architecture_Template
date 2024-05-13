package com.astro.test.faisalbahri.data.datasource.remote.source.user

import com.astro.test.faisalbahri.data.datasource.remote.api.user.Api
import com.astro.test.faisalbahri.data.model.user.GithubUsersSearchResponse
import retrofit2.Response
import javax.inject.Inject

internal class UserDataSourceImpl @Inject constructor(
    private val api: Api,
) : UserDataSource {
    override suspend fun getSearchUser(q: String): Response<GithubUsersSearchResponse> {
        return api.getSearchUser(q)
    }
}