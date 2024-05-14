package com.kanzankazu.composecleanarchitecture.data.datasource

import com.kanzankazu.composecleanarchitecture.data.model.user.GithubUsersSearchData
import com.kanzankazu.composecleanarchitecture.data.datasource.remote.api.UserApi
import com.kanzankazu.composecleanarchitecture.data.datasource.remote.source.user.UserDataSourceImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class UserDataSourceTest {

    private val userApi = mockk<UserApi>()

    private lateinit var dataSource: UserDataSourceImpl

    @Before
    fun setUp() {
        dataSource = UserDataSourceImpl(userApi)
    }

    @Test
    fun `getSearchUser returns expected response`() = runTest {
        val expectedResponse = mockk<Response<GithubUsersSearchData>>()
        val queryRequest = "Kanzan"
        coEvery { userApi.getSearchUser(queryRequest) } returns expectedResponse

        val result = dataSource.getSearchUser(queryRequest)

        assertEquals(expectedResponse, result)
    }
}