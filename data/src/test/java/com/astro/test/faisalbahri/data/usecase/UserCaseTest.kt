package com.astro.test.faisalbahri.data.usecase

import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.domain.mapper.user.GithubUsersSearchDomainModelMapper
import com.astro.test.faisalbahri.data.model.user.GithubUsersSearchResponse
import com.astro.test.faisalbahri.data.repository.user.UserRepository
import com.astro.test.faisalbahri.domain.usecase.user.UserUseCaseImpl
import com.astro.test.faisalbahri.domain.model.GithubUsersSearch
import com.astro.test.faisalbahri.domain.usecase.user.UserUseCase
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
    private val mockListMapper = mockk<com.astro.test.faisalbahri.domain.mapper.user.GithubUsersSearchDomainModelMapper>()

    // UseCase
    private lateinit var getListUseCase: UserUseCase

    // Test data
    private val mockListResponseModel = mockk<GithubUsersSearchResponse>()
    private val mockListModel = mockk<GithubUsersSearch>()
    private val searchQueryRequest = "Kanzan"

    @Before
    fun setUp() {
        getListUseCase = com.astro.test.faisalbahri.domain.usecase.user.UserUseCaseImpl(Dispatchers.Unconfined, mockListRepository, mockListMapper)
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