package com.muhammad.cityinput.data.repository

import com.muhammad.cityinput.data.local.dao.CityDao
import com.muhammad.cityinput.data.local.entities.RecentCity
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val dao: CityDao
) : CityRepository {
    override suspend fun saveCity(cityName: String) {
        val exists = dao.exists(cityName)

        if (!exists) {
            dao.insert(RecentCity(cityName))
        }
    }

    override suspend fun getRecentCities(): List<String> = dao.getRecentCities()
}