package com.kanzankazu.composecleanarchitecture.data.model.user


import com.kanzankazu.composecleanarchitecture.common.model.DataModel
import com.google.gson.annotations.SerializedName

data class GithubUsersSearchData(
    @SerializedName("incomplete_results") var incompleteResults: Boolean? = null,
    @SerializedName("items") var items: List<GithubUsersItemData?>? = null,
    @SerializedName("total_count") var totalCount: Int? = null,
) : DataModel