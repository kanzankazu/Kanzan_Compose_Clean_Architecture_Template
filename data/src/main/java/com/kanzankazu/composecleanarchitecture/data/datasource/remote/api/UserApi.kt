package com.kanzankazu.composecleanarchitecture.data.datasource.remote.api

import com.kanzankazu.composecleanarchitecture.data.model.user.GithubUsersSearchData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("search/users")
    suspend fun getSearchUser(
        @Query("q") q: String,
        @Query("per_page") perPage: Int = 5,
    ): Response<GithubUsersSearchData>
}