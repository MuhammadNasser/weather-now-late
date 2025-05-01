package com.muhammad.cityinput.domain

import com.muhammad.core.repository.CityInputRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify

class SaveCityUseCaseTest {

    private lateinit var repository: CityInputRepository
    private lateinit var useCase: SaveCityUseCase

    @Before
    fun setup() {
        repository = mock(CityInputRepository::class.java)
        useCase = SaveCityUseCase(repository)
    }

    @Test
    fun `invoke should call repository with correct city name`() = runBlocking {
        val city = "Paris"
        useCase(city)

        verify(repository).saveCity(city)
    }
}