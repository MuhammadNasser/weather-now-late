package com.muhammad.currentweather.domain

import com.muhammad.core.model.local.CurrentWeather
import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.repository.WeatherRepository
import com.muhammad.data.mapper.toCurrentWeather
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(currentWeatherQuery: CurrentWeatherQuery): Result<CurrentWeather> {
        return try {
            Result.success(repository.getCurrentWeather(currentWeatherQuery).toCurrentWeather())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}