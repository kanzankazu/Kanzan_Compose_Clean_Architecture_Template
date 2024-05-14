package com.kanzankazu.composecleanarchitecture.data.datasource.remote.source.user

import com.kanzankazu.composecleanarchitecture.data.model.user.GithubUsersSearchData
import retrofit2.Response

interface UserDataSource {
    suspend fun getSearchUser(q: String): Response<GithubUsersSearchData>
}