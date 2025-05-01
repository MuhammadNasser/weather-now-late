package com.muhammad.cityinput.domain

import com.muhammad.core.repository.CityInputRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GetRecentCitiesUseCaseTest {

    private lateinit var repo: CityInputRepository
    private lateinit var useCase: GetRecentCitiesUseCase

    @Before
    fun setup() {
        repo = Mockito.mock(CityInputRepository::class.java)
        useCase = GetRecentCitiesUseCase(repo)
    }

    @Test
    fun `invoke should return recent cities from repository`(): Unit = runBlocking {
        val expected = listOf("Cairo", "New York")
        whenever(repo.getRecentCities()).thenReturn(expected)

        val result = useCase()

        assertEquals(expected, result)
        verify(repo).getRecentCities()
    }
}