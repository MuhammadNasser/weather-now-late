package com.muhammad.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecentCity(
    @PrimaryKey
    val name: String,
)