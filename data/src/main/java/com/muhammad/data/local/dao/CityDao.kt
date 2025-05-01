package com.muhammad.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muhammad.data.local.entities.RecentCity

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(city: RecentCity)

    @Query("SELECT name FROM RecentCity")
    suspend fun getRecentCities(): List<String>

    @Query("SELECT EXISTS(SELECT 1 FROM RecentCity WHERE name = :name)")
    suspend fun exists(name: String): Boolean
}