package com.muhammad.cityinput.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muhammad.cityinput.data.local.dao.CityDao
import com.muhammad.cityinput.data.local.entities.RecentCity

@Database(entities = [RecentCity::class], version = 1)
abstract class CityDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}