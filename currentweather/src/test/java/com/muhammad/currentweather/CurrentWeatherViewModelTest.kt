package com.muhammad.currentweather

import app.cash.turbine.test
import com.muhammad.core.model.local.CurrentWeather
import com.muhammad.currentweather.domain.GetCurrentWeatherUseCase
import com.muhammad.currentweather.presentation.CurrentWeatherViewModel
import com.muhammad.currentweather.presentation.WeatherUiState
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CurrentWeatherViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var useCase: GetCurrentWeatherUseCase
    private lateinit var viewModel: CurrentWeatherViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        useCase = mockk()
        viewModel = CurrentWeatherViewModel(useCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getWeather emits Loading then Success when use case succeeds`() = runTest {
        // Arrange
        val mockWeather = CurrentWeather(25.0, 25.0, "Cairo")
        coEvery { useCase(any()) } returns Result.success(mockWeather)

        // Act & Assert
        viewModel.weatherState.test {
            viewModel.getWeather("Cairo")

            assertEquals(WeatherUiState.Loading, awaitItem()) // initial state
            testDispatcher.scheduler.advanceUntilIdle()
            assertEquals(WeatherUiState.Success(mockWeather), awaitItem())
        }
    }

    @Test
    fun `getWeather emits Loading then Error when use case fails`() = runTest {
        // Arrange
        val error = RuntimeException("API failed")
        coEvery { useCase(any()) } returns Result.failure(error)

        // Act & Assert
        viewModel.weatherState.test {
            viewModel.getWeather("Cairo")

            assertEquals(WeatherUiState.Loading, awaitItem())
            testDispatcher.scheduler.advanceUntilIdle()
            assertEquals(WeatherUiState.Error("API failed"), awaitItem())
        }
    }
}
