package com.example.busschedule.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Stop::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun stopDao(): StopDao

    companion object {
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                                context,
                                AppDatabase::class.java,
                                "app_database"
                            )
                                .createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration(false)
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }
}