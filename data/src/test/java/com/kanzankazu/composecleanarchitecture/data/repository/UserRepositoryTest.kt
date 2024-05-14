package com.kanzankazu.composecleanarchitecture.data.repository

import com.kanzankazu.composecleanarchitecture.common.utils.Resource
import com.kanzankazu.composecleanarchitecture.data.model.user.GithubUsersSearchData
import com.kanzankazu.composecleanarchitecture.data.datasource.remote.source.user.UserDataSource
import com.kanzankazu.composecleanarchitecture.data.repository.user.UserRepository
import com.kanzankazu.composecleanarchitecture.data.repository.user.UserRepositoryImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class UserRepositoryTest {

    private val userDataSource = mockk<UserDataSource>()
    private lateinit var userRepository: UserRepository

    private val githubUsersSearchResponse = GithubUsersSearchData(
        incompleteResults = null,
        items = listOf(),
        totalCount = null
    )

    @Before
    fun setUp() {
        userRepository = UserRepositoryImpl(userDataSource)
    }

    @Test
    fun `getSearchUser returns success`() = runBlocking {
        val mockResponse = mockk<Response<GithubUsersSearchData>>()
        val searchUserParam = "Kanzan"
        val searchUserParamSlot = slot<String>()
        every { mockResponse.isSuccessful } returns true
        every { mockResponse.body() } returns githubUsersSearchResponse

        val expectedResource = Resource.Success(githubUsersSearchResponse)
        coEvery { userDataSource.getSearchUser(capture(searchUserParamSlot)) } returns mockResponse

        val result = userRepository.getSearchUser(searchUserParam)

        assertEquals(searchUserParam, searchUserParamSlot.captured)
        assertEquals(expectedResource, result)
        coVerify(exactly = 1) { userDataSource.getSearchUser(searchUserParam) }
    }
}