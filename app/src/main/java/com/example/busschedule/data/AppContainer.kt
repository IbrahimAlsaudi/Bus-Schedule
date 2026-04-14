package com.example.busschedule.data

import android.content.Context
import com.example.busschedule.data.database.AppDatabase
import com.example.busschedule.data.database.AppDatabase_Impl
import com.example.busschedule.data.repositories.OfflineStopRepository
import com.example.busschedule.data.repositories.StopRepository

interface AppContainer {
    val stopRepository: StopRepository
}

class AppContainerImpl(context: Context) : AppContainer {
    override val stopRepository: StopRepository by lazy {
        OfflineStopRepository(
            stopDao = AppDatabase.getDatabase(context).stopDao()
        )
    }

}