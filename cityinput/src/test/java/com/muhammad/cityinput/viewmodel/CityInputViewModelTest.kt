package com.muhammad.cityinput.viewmodel

import com.muhammad.cityinput.domain.GetRecentCitiesUseCase
import com.muhammad.cityinput.domain.SaveCityUseCase
import com.muhammad.cityinput.presentation.CityInputViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import io.mockk.coVerify

@OptIn(ExperimentalCoroutinesApi::class)
class CityInputViewModelTest {

    private lateinit var saveCityUseCase: SaveCityUseCase
    private lateinit var getRecentCitiesUseCase: GetRecentCitiesUseCase
    private lateinit var viewModel: CityInputViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        saveCityUseCase = mockk(relaxed = true)
        getRecentCitiesUseCase = mockk()

        // default behavior for recent cities
        coEvery { getRecentCitiesUseCase() } returns listOf("Cairo", "London")

        viewModel = CityInputViewModel(saveCityUseCase, getRecentCitiesUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `init should load recent cities`() = runTest {
        advanceUntilIdle() // wait for init coroutine

        val state = viewModel.state.value
        assertEquals(listOf("Cairo", "London"), state.recentCities)
    }

    @Test
    fun `onCityNameChanged should update city name in state`() {
        viewModel.onCityNameChanged("Alex")

        assertEquals("Alex", viewModel.state.value.cityName)
    }

    @Test
    fun `saveCity should trigger saveCityUseCase and reload recent cities`() = runTest {
        viewModel.onCityNameChanged("Giza")
        viewModel.saveCity()

        advanceUntilIdle()

        coVerify { saveCityUseCase("Giza") }
        coVerify { getRecentCitiesUseCase() } // called again after saving
    }

    @Test
    fun `saveCity should not be called if city is empty`() = runTest {
        viewModel.onCityNameChanged("  ")
        viewModel.saveCity()

        advanceUntilIdle()

        coVerify(exactly = 0) { saveCityUseCase(any()) }
    }
}
