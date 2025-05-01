package com.muhammad.data.remote.source

import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.model.remote.CurrentWeatherResponse
import com.muhammad.core.source.remote.WeatherRemoteDataSource
import com.muhammad.data.remote.api.WeatherApiService
import javax.inject.Inject

class WeatherRemoteDataSourceImpl @Inject constructor(
    private val api: WeatherApiService
) : WeatherRemoteDataSource {
    override suspend fun getCurrentWeather(currentWeatherQuery: CurrentWeatherQuery): CurrentWeatherResponse {
        return api.getCurrentWeather(
            currentWeatherQuery.cityName,
            "apiKey",
            currentWeatherQuery.units
        )
    }
}