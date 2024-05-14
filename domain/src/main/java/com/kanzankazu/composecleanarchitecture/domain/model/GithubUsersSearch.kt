package com.kanzankazu.composecleanarchitecture.domain.model


import com.kanzankazu.composecleanarchitecture.common.model.DomainModel

data class GithubUsersSearch(
    var incompleteResults: Boolean = false,
    var items: List<GithubUsersItem> = emptyList(),
    var totalCount: Int = 0,
) : DomainModel