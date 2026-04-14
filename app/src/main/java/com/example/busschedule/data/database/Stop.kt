package com.example.busschedule.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Schedule")
data class Stop(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("stop_name")
    val name: String,
    @ColumnInfo("arrival_time")
    val arrivalTimeInMillis: Int
)
