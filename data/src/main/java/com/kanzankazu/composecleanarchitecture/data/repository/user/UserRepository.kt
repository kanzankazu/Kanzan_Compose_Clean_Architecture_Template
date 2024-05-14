package com.kanzankazu.composecleanarchitecture.data.repository.user

import com.kanzankazu.composecleanarchitecture.common.utils.Resource
import com.kanzankazu.composecleanarchitecture.data.model.user.GithubUsersSearchData

interface UserRepository {
    suspend fun getSearchUser(q: String): Resource<GithubUsersSearchData>
}