package com.example.busschedule.data.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StopDao {

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAllStops(): Flow<List<Stop>>

    @Query("SELECT * FROM Schedule WHERE stop_name = :name")
    fun getByStopName(name: String): Flow<List<Stop>>
}