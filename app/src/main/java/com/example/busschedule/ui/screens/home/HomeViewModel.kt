package com.example.busschedule.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busschedule.data.database.Stop
import com.example.busschedule.data.repositories.StopRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(stopRepository: StopRepository) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> = stopRepository.getAllStopsStream()
        .map {stopDatabaseList -> HomeUiState(stopDatabaseList) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = HomeUiState()
        )

}

data class HomeUiState(val stopList: List<Stop> = listOf())