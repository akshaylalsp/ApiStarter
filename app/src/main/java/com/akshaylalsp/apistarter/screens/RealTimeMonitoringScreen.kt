package com.akshaylalsp.apistarter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akshaylalsp.apistarter.models.LiveReading
import com.akshaylalsp.apistarter.repository.FirebaseRepository

@Composable
fun RealTimeMonitoringScreen(clusterId: Int, meterId: Int) {
    var liveReading by remember { mutableStateOf<LiveReading?>(null) }

    LaunchedEffect(Unit) {
        FirebaseRepository.getLiveReading(clusterId, meterId) {
            liveReading = it
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Real-Time Monitoring", style = MaterialTheme.typography.headlineSmall)
        liveReading?.let {
            Text(text = "Timestamp: ${it.timestamp}")
            Text(text = "Voltage: ${it.voltage}V")
            Text(text = "Power: ${it.power}W")
            Text(text = "Total Unit: ${it.unitConsumed} kWh")
        } ?: Text(text = "Loading...")
    }
}
