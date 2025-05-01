package com.muhammad.data.remote.source

import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.model.query.DayForecastQuery
import com.muhammad.core.model.remote.CurrentWeatherResponse
import com.muhammad.core.model.remote.ForecastResponse
import com.muhammad.core.source.remote.WeatherRemoteDataSource
import com.muhammad.data.BuildConfig.API_KEY
import com.muhammad.data.remote.api.WeatherApiService
import javax.inject.Inject

class WeatherRemoteDataSourceImpl @Inject constructor(
    private val api: WeatherApiService
) : WeatherRemoteDataSource {
    override suspend fun getCurrentWeather(currentWeatherQuery: CurrentWeatherQuery): CurrentWeatherResponse =
        api.getCurrentWeather(
            currentWeatherQuery.cityName,
            API_KEY,
            currentWeatherQuery.units
        )

    override suspend fun getDayForecast(dayForecastQuery: DayForecastQuery): ForecastResponse {
        return api.getDayForecast(
            dayForecastQuery.lat,
            dayForecastQuery.lon,
            API_KEY,
            dayForecastQuery.units
        )
    }
}