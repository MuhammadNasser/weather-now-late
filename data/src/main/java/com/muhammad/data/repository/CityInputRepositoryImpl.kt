package com.muhammad.data.repository

import com.muhammad.core.repository.CityInputRepository
import com.muhammad.core.source.local.CityInputLocalDataSource
import javax.inject.Inject

class CityInputRepositoryImpl @Inject constructor(
    private val localDataSource: CityInputLocalDataSource
) : CityInputRepository {
    override suspend fun saveCity(cityName: String) = localDataSource.saveCity(cityName)

    override suspend fun getRecentCities(): List<String> = localDataSource.getRecentCities()
}