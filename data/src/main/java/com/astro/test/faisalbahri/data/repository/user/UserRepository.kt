package com.astro.test.faisalbahri.data.repository.user

import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.data.model.user.GithubUsersSearchResponse

interface UserRepository {
    suspend fun getSearchUser(q: String): Resource<GithubUsersSearchResponse>
}