package com.muhammad.core.repository

interface CityInputRepository {
    suspend fun saveCity(cityName: String)
    suspend fun getRecentCities(): List<String>
}