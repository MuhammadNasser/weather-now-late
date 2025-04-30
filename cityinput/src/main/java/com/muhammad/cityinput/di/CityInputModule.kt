package com.muhammad.cityinput.di

import android.content.Context
import androidx.room.Room
import com.muhammad.cityinput.data.local.dao.CityDao
import com.muhammad.cityinput.data.local.database.CityDatabase
import com.muhammad.cityinput.data.repository.CityRepository
import com.muhammad.cityinput.data.repository.CityRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CityInputModule {

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
    fun provideCityRepository(dao: CityDao): CityRepository = CityRepositoryImpl(dao)
}