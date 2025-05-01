package com.muhammad.dayforecast.domain

import com.muhammad.core.model.local.DailyForecast
import com.muhammad.core.model.query.DayForecastQuery
import com.muhammad.core.repository.WeatherRepository
import com.muhammad.data.mapper.toDailyWeather
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(query: DayForecastQuery): Result<List<DailyForecast>> {
        return try {
            val forecastList = repository.getDayForecast(query)
                .daily?.take(7)?.map { it.toDailyWeather() } ?: emptyList()

            Result.success(forecastList)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}