package com.muhammad.data.repository

import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.model.query.DayForecastQuery
import com.muhammad.core.model.remote.CurrentWeatherResponse
import com.muhammad.core.model.remote.ForecastResponse
import com.muhammad.core.repository.WeatherRepository
import com.muhammad.core.source.remote.WeatherRemoteDataSource
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource
) : WeatherRepository {
    override suspend fun getCurrentWeather(currentWeatherQuery: CurrentWeatherQuery): CurrentWeatherResponse =
        remoteDataSource.getCurrentWeather(currentWeatherQuery)

    override suspend fun getDayForecast(dayForecastQuery: DayForecastQuery): ForecastResponse =
        remoteDataSource.getDayForecast(dayForecastQuery)
}