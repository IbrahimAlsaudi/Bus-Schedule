package com.example.busschedule.data.repositories

import com.example.busschedule.data.database.Stop
import com.example.busschedule.data.database.StopDao
import kotlinx.coroutines.flow.Flow

class OfflineStopRepository(private val stopDao: StopDao): StopRepository {

    override fun getAllStopsStream() = stopDao.getAllStops()


    override fun getStopByName(name: String) = stopDao.getByStopName(name)

}