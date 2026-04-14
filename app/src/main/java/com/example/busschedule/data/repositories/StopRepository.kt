package com.example.busschedule.data.repositories

import com.example.busschedule.data.database.Stop
import kotlinx.coroutines.flow.Flow

interface StopRepository {

    fun getAllStopsStream(): Flow<List<Stop>>

    fun getStopByName(name: String): Flow<List<Stop>>
}