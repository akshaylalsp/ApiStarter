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
import com.akshaylalsp.apistarter.models.PeakUsage
import com.akshaylalsp.apistarter.repository.FirebaseRepository

@Composable
fun PeakUsageScreen(clusterId: Int) {
    var peakData by remember { mutableStateOf<PeakUsage?>(null) }

    LaunchedEffect(Unit) {
        FirebaseRepository.getPeakUsage(clusterId) {
            peakData = it
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Peak Usage", style = MaterialTheme.typography.headlineSmall)
        peakData?.let {
            Text(text = "Avg Consumption: ${it.avgConsumption}W")
            Text(text = if (it.peak) "⚠️ Peak Usage Detected!" else "✅ Normal Consumption")
        } ?: Text(text = "Loading...")
    }
}
