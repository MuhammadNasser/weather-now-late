package com.muhammad.core.source.remote

import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.model.remote.CurrentWeatherResponse

interface WeatherRemoteDataSource {
    suspend fun getCurrentWeather(currentWeatherQuery: CurrentWeatherQuery): CurrentWeatherResponse
}