package com.muhammad.dayforecast.di

import com.muhammad.core.repository.WeatherRepository
import com.muhammad.dayforecast.domain.GetForecastUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DayForecastModule {

    @Provides
    fun provideGetForecastUseCase(repo: WeatherRepository): GetForecastUseCase {
        return GetForecastUseCase(repo)
    }
}