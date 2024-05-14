package com.kanzankazu.composecleanarchitecture.domain.usecase

import com.kanzankazu.composecleanarchitecture.common.utils.Resource
import com.kanzankazu.composecleanarchitecture.data.model.user.GithubUsersSearchData
import com.kanzankazu.composecleanarchitecture.data.repository.user.UserRepository
import com.kanzankazu.composecleanarchitecture.domain.mapper.user.GithubUsersSearchDomainModelMapper
import com.kanzankazu.composecleanarchitecture.domain.model.GithubUsersSearch
import com.kanzankazu.composecleanarchitecture.domain.usecase.user.UserUseCase
import com.kanzankazu.composecleanarchitecture.domain.usecase.user.UserUseCaseImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class UserCaseTest {

    private val mockListRepository = mockk<UserRepository>()
    private val mockListMapper = mockk<GithubUsersSearchDomainModelMapper>()

    // UseCase
    private lateinit var getListUseCase: UserUseCase

    // Test data
    private val mockListResponseModel = mockk<GithubUsersSearchData>()
    private val mockListModel = mockk<GithubUsersSearch>()
    private val searchQueryRequest = "Kanzan"

    @Before
    fun setUp() {
        getListUseCase = UserUseCaseImpl(Dispatchers.Unconfined, mockListRepository, mockListMapper)
    }

    @Test
    fun `invoke returns Resource Success`() = runBlocking {
        coEvery { mockListRepository.getSearchUser(searchQueryRequest) } returns Resource.Success(mockListResponseModel)
        coEvery { mockListMapper.mapToDomainModel(mockListResponseModel) } returns mockListModel

        val result = getListUseCase.invoke(searchQueryRequest)

        assertTrue(result is Resource.Success)
        assertEquals(mockListModel, (result as Resource.Success).data)
    }

    @Test
    fun `invoke returns Resource Failure`() = runBlocking {
        val errorMessage = "An error occurred"
        coEvery { mockListRepository.getSearchUser(searchQueryRequest) } returns Resource.Failure(errorMessage)

        val result = getListUseCase.invoke(searchQueryRequest)

        assertTrue(result is Resource.Failure)
        assertEquals(errorMessage, (result as Resource.Failure).error)
    }
}