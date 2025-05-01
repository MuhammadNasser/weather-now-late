package com.muhammad.data

import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.model.query.DayForecastQuery
import com.muhammad.core.model.remote.CurrentWeatherResponse
import com.muhammad.core.model.remote.ForecastResponse
import com.muhammad.core.source.remote.WeatherRemoteDataSource
import com.muhammad.data.repository.CurrentWeatherRepositoryImpl
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.whenever

class CurrentWeatherRepositoryImplTest {

    private lateinit var remoteDataSource: WeatherRemoteDataSource
    private lateinit var repository: CurrentWeatherRepositoryImpl

    @Before
    fun setUp() {
        remoteDataSource = mock(WeatherRemoteDataSource::class.java)
        repository = CurrentWeatherRepositoryImpl(remoteDataSource)
    }

    @Test
    fun `getCurrentWeather should return correct data`(): Unit = runBlocking {
        val query = CurrentWeatherQuery("Cairo")
        val expected = mock(CurrentWeatherResponse::class.java)

        whenever(remoteDataSource.getCurrentWeather(query)).thenReturn(expected)

        val result = repository.getCurrentWeather(query)

        assertEquals(expected, result)
        verify(remoteDataSource).getCurrentWeather(query)
    }

    @Test
    fun `getDayForecast should return correct data`(): Unit = runBlocking {
        val query = DayForecastQuery("Cairo")
        val expected = mock(ForecastResponse::class.java)

        whenever(remoteDataSource.getDayForecast(query)).thenReturn(expected)

        val result = repository.getDayForecast(query)

        assertEquals(expected, result)
        verify(remoteDataSource).getDayForecast(query)
    }
}