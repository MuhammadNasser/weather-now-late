package com.muhammad.cityinput.data.repository

interface CityRepository {
    suspend fun saveCity(cityName: String)
    suspend fun getRecentCities(): List<String>
}