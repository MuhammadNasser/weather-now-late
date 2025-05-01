package com.muhammad.data

import com.muhammad.core.source.local.CityInputLocalDataSource
import com.muhammad.data.repository.CityInputRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever

class CityInputRepositoryImplTest {

    private lateinit var localDataSource: CityInputLocalDataSource
    private lateinit var repository: CityInputRepositoryImpl

    @Before
    fun setUp() {
        localDataSource = mock(CityInputLocalDataSource::class.java)
        repository = CityInputRepositoryImpl(localDataSource)
    }

    @Test
    fun `saveCity should call localDataSource saveCity`(): Unit = runBlocking {
        val city = "Cairo"
        repository.saveCity(city)
        verify(localDataSource).saveCity(city)
    }

    @Test
    fun `getRecentCities should return data from localDataSource`(): Unit = runBlocking {
        val cities = listOf("Cairo", "London")
        whenever(localDataSource.getRecentCities()).thenReturn(cities)

        val result = repository.getRecentCities()

        assert(result == cities)
        verify(localDataSource).getRecentCities()
    }
}