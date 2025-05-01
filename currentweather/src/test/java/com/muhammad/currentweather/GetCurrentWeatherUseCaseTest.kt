package com.muhammad.currentweather

import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.model.remote.CurrentWeatherResponse
import com.muhammad.core.repository.WeatherRepository
import com.muhammad.currentweather.domain.GetCurrentWeatherUseCase
import com.muhammad.data.mapper.toCurrentWeather
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetCurrentWeatherUseCaseTest {

    private lateinit var repository: WeatherRepository
    private lateinit var useCase: GetCurrentWeatherUseCase

    @Before
    fun setUp() {
        repository = mockk()
        useCase = GetCurrentWeatherUseCase(repository)
    }

    @Test
    fun `invoke should return success result when repository returns data`() = runTest {
        // Arrange
        val query = CurrentWeatherQuery("Cairo", "metric")
        val response = CurrentWeatherResponse(/* mock fields */)
        val expected = response.toCurrentWeather()

        coEvery { repository.getCurrentWeather(query) } returns response

        // Act
        val result = useCase(query)

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(expected, result.getOrNull())
    }

    @Test
    fun `invoke should return failure result when repository throws exception`() = runTest {
        // Arrange
        val query = CurrentWeatherQuery("Cairo", "metric")
        val exception = RuntimeException("Network error")

        coEvery { repository.getCurrentWeather(query) } throws exception

        // Act
        val result = useCase(query)

        // Assert
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }
}
