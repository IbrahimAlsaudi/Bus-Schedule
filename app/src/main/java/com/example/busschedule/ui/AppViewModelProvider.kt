package com.example.busschedule.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.ScheduleApplication
import com.example.busschedule.ui.screens.home.HomeViewModel
import com.example.busschedule.ui.screens.stop.StopViewModel

object AppViewModelProvider {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                stopRepository = scheduleApplication().container.stopRepository
            )
        }

        initializer {
            StopViewModel(
                savedStateHandle = this.createSavedStateHandle(),
                stopRepository = scheduleApplication().container.stopRepository
            )
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [ScheduleApplication].
 */
fun CreationExtras.scheduleApplication(): ScheduleApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ScheduleApplication)
