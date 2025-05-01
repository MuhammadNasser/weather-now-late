package com.muhammad.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muhammad.data.local.dao.CityDao
import com.muhammad.data.local.entities.RecentCity

@Database(entities = [RecentCity::class], version = 1, exportSchema = false)
abstract class CityDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}