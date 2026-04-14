package com.example.busschedule.ui.screens.stop

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busschedule.data.database.Stop
import com.example.busschedule.data.repositories.StopRepository
import com.example.busschedule.ui.navigation.NavigationDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.stateIn

class StopViewModel(
    savedStateHandle: SavedStateHandle,
    stopRepository: StopRepository) : ViewModel() {

    private val stopName: String = checkNotNull(savedStateHandle[NavigationDestination.StopNav.stopNameArg])

    val uiState: StateFlow<List<Stop>> = stopRepository.getStopByName(stopName)
        .filterNotNull()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = emptyList()
        )

}

