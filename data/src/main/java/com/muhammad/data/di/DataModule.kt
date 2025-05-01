package com.muhammad.data.di

import android.content.Context
import androidx.room.Room
import com.muhammad.core.repository.CityInputRepository
import com.muhammad.core.repository.WeatherRepository
import com.muhammad.core.source.local.CityInputLocalDataSource
import com.muhammad.core.source.remote.WeatherRemoteDataSource
import com.muhammad.data.local.dao.CityDao
import com.muhammad.data.local.database.CityDatabase
import com.muhammad.data.local.source.CityInputLocalDataSourceImpl
import com.muhammad.data.remote.api.WeatherApiService
import com.muhammad.data.remote.source.WeatherRemoteDataSourceImpl
import com.muhammad.data.repository.CityInputRepositoryImpl
import com.muhammad.data.repository.CurrentWeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CityDatabase =
        Room.databaseBuilder(
            context,
            CityDatabase::class.java,
            "city_db"
        ).build()

    @Provides
    fun provideCityDao(db: CityDatabase): CityDao = db.cityDao()

    @Provides
    fun provideCityRepository(localDataSource: CityInputLocalDataSource): CityInputRepository =
        CityInputRepositoryImpl(localDataSource)

    @Provides
    fun provideWeatherRepository(remoteDataSource: WeatherRemoteDataSource): WeatherRepository =
        CurrentWeatherRepositoryImpl(remoteDataSource)

    @Provides
    fun provideCityInputLocalDataSource(dao: CityDao): CityInputLocalDataSource =
        CityInputLocalDataSourceImpl(dao)

    @Provides
    fun provideWeatherRemoteDataSource(api: WeatherApiService): WeatherRemoteDataSource =
        WeatherRemoteDataSourceImpl(api)
}