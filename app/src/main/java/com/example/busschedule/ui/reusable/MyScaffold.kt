package com.example.busschedule.ui.reusable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.busschedule.R
import com.example.busschedule.data.database.Stop
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun MyScaffold(
    stopList: List<Stop>,
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    onStopClick: (Stop) -> Unit = {},
    navigateBack: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                title = title,
                canNavigateBack = canNavigateBack,
                navigateBack = navigateBack
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            NameAndArrivalTimeRow(
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            )
            HorizontalDivider()
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(
                    items = stopList,
                    key = { it.id }
                ) { stop ->
                    StopDetailsRow(
                        stop = stop,
                        canNavigateBack = canNavigateBack,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onStopClick(stop) }
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun NameAndArrivalTimeRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.stop_name),
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = stringResource(R.string.arrival_time),
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun StopDetailsRow(
    stop: Stop,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if(!canNavigateBack){stop.name}
            else {"--"},
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = SimpleDateFormat("h:mm a", Locale.getDefault())
                .format(Date(stop.arrivalTimeInMillis.toLong() * 1000)),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
