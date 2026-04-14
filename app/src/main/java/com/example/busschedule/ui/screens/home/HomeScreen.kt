package com.example.busschedule.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.busschedule.R
import com.example.busschedule.ui.AppViewModelProvider
import com.example.busschedule.ui.reusable.MyScaffold


@Composable
fun HomeScreen(
    navigateToDetailsScreen: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val homeUiState by viewModel.homeUiState.collectAsState()
    MyScaffold(
        stopList = homeUiState.stopList,
        title = stringResource(R.string.app_name),
        canNavigateBack = false,
        onStopClick = { navigateToDetailsScreen(it.name) },
        modifier = modifier
    )
}
