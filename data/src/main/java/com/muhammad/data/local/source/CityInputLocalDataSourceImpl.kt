package com.muhammad.data.local.source

import com.muhammad.core.source.local.CityInputLocalDataSource
import com.muhammad.data.local.dao.CityDao
import com.muhammad.data.local.entities.RecentCity
import javax.inject.Inject

class CityInputLocalDataSourceImpl @Inject constructor(
    private val dao: CityDao
) : CityInputLocalDataSource {
    override suspend fun saveCity(cityName: String) {
        val exists = dao.exists(cityName)

        if (!exists) {
            dao.insert(RecentCity(cityName))
        }
    }

    override suspend fun getRecentCities(): List<String> = dao.getRecentCities()
}