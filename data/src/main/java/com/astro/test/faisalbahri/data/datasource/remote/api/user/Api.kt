package com.astro.test.faisalbahri.data.datasource.remote.api.user

import com.astro.test.faisalbahri.data.model.user.GithubUsersSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    suspend fun getSearchUser(
        @Query("q") q: String,
        @Query("per_page") perPage: Int = 5,
    ): Response<GithubUsersSearchResponse>
}