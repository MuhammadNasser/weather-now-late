package com.muhammad.cityinput.di

import com.muhammad.cityinput.domain.GetRecentCitiesUseCase
import com.muhammad.cityinput.domain.SaveCityUseCase
import com.muhammad.core.repository.CityInputRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object CityInputModule {

    @Provides
    fun provideSaveCityUseCase(repo: CityInputRepository): SaveCityUseCase {
        return SaveCityUseCase(repo)
    }

    @Provides
    fun provideGetRecentCitiesUseCase(repo: CityInputRepository): GetRecentCitiesUseCase {
        return GetRecentCitiesUseCase(repo)
    }
}