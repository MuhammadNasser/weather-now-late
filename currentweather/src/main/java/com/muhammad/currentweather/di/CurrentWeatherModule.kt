package com.muhammad.currentweather.di

import com.muhammad.core.repository.WeatherRepository
import com.muhammad.currentweather.domain.GetCurrentWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object CurrentWeatherModule {

    @Provides
    fun provideGetCurrentWeatherUseCase(repo: WeatherRepository): GetCurrentWeatherUseCase {
        return GetCurrentWeatherUseCase(repo)
    }
}