package com.astro.test.faisalbahri.data.datasource.remote.source.user

import com.astro.test.faisalbahri.data.model.user.GithubUsersSearchResponse
import retrofit2.Response

interface UserDataSource {
    suspend fun getSearchUser(q: String): Response<GithubUsersSearchResponse>
}