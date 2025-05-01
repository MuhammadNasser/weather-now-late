package com.muhammad.core.repository

import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.model.remote.CurrentWeatherResponse

interface WeatherRepository {
    suspend fun getCurrentWeather(currentWeatherQuery: CurrentWeatherQuery): CurrentWeatherResponse
}