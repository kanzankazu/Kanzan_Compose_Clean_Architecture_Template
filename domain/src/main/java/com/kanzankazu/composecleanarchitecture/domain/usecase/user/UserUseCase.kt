package com.kanzankazu.composecleanarchitecture.domain.usecase.user

import com.kanzankazu.composecleanarchitecture.common.utils.Resource
import com.kanzankazu.composecleanarchitecture.domain.model.GithubUsersSearch

interface UserUseCase {
    suspend operator fun invoke(q: String): Resource<GithubUsersSearch>
}