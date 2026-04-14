package com.example.busschedule.ui.screens.stop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.busschedule.data.database.Stop
import com.example.busschedule.ui.AppViewModelProvider
import com.example.busschedule.ui.navigation.NavigationDestination
import com.example.busschedule.ui.reusable.MyScaffold


@Composable
fun StopArrivalsScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: StopViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    val uiState by viewModel.uiState.collectAsState()
    MyScaffold(
        stopList = uiState,
        title = uiState.firstOrNull()?.name ?: "",
        canNavigateBack = true,
        navigateBack = navigateBack
    )
}