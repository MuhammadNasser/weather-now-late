package com.muhammad.core.source.local

interface CityInputLocalDataSource {
    suspend fun saveCity(cityName: String)
    suspend fun getRecentCities(): List<String>
}