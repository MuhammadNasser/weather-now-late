package com.muhammad.data.repository

import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.model.remote.CurrentWeatherResponse
import com.muhammad.core.repository.WeatherRepository
import com.muhammad.core.source.remote.WeatherRemoteDataSource
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource
) : WeatherRepository {
    override suspend fun getCurrentWeather(currentWeatherQuery: CurrentWeatherQuery): CurrentWeatherResponse {
        return remoteDataSource.getCurrentWeather(cityName)
    }
}