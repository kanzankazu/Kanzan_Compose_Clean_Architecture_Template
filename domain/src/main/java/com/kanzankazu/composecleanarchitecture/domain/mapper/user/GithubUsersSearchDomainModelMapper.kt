package com.kanzankazu.composecleanarchitecture.domain.mapper.user

import com.kanzankazu.composecleanarchitecture.common.model.DataToDomainModelMapper
import com.kanzankazu.composecleanarchitecture.common.extensions.orNull
import com.kanzankazu.composecleanarchitecture.common.extensions.orNullListNotNot
import com.kanzankazu.composecleanarchitecture.data.model.user.GithubUsersSearchData
import com.kanzankazu.composecleanarchitecture.domain.model.GithubUsersItem
import com.kanzankazu.composecleanarchitecture.domain.model.GithubUsersSearch
import javax.inject.Inject

class GithubUsersSearchDomainModelMapper @Inject constructor() :
    DataToDomainModelMapper<GithubUsersSearchData, GithubUsersSearch> {
    override fun mapToDomainModel(responseModel: GithubUsersSearchData): GithubUsersSearch = with(responseModel) {
        GithubUsersSearch(
            incompleteResults = incompleteResults.orNull(),
            items = items.orNullListNotNot(GithubUsersItem()) {
                GithubUsersItem(
                    avatarUrl = avatarUrl.orNull(),
                    eventsUrl = eventsUrl.orNull(),
                    followersUrl = followersUrl.orNull(),
                    followingUrl = followingUrl.orNull(),
                    gistsUrl = gistsUrl.orNull(),
                    gravatarId = gravatarId.orNull(),
                    htmlUrl = htmlUrl.orNull(),
                    id = id.orNull(),
                    login = login.orNull(),
                    nodeId = nodeId.orNull(),
                    organizationsUrl = organizationsUrl.orNull(),
                    receivedEventsUrl = receivedEventsUrl.orNull(),
                    reposUrl = reposUrl.orNull(),
                    score = score.orNull(),
                    siteAdmin = siteAdmin.orNull(),
                    starredUrl = starredUrl.orNull(),
                    subscriptionsUrl = subscriptionsUrl.orNull(),
                    type = type.orNull(),
                    url = url.orNull()
                )
            },
            totalCount = totalCount.orNull()
        )
    }
}
