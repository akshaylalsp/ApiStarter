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
import com.akshaylalsp.apistarter.models.AnomalyDetection
import com.akshaylalsp.apistarter.repository.FirebaseRepository

@Composable
fun AnomalyDetectionScreen(clusterId: Int) {
    var anomalyData by remember { mutableStateOf<AnomalyDetection?>(null) }

    LaunchedEffect(Unit) {
        FirebaseRepository.getAnomalyDetection(clusterId) {
            anomalyData = it
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Anomaly Detection", style = MaterialTheme.typography.headlineSmall)
        anomalyData?.let {
            Text(text = "Active Meters: ${it.activeMeters}")
            Text(text = "Total Meters: ${it.totalMeters}")
            Text(text = if (it.anomaly) "⚠️ Anomaly Detected!" else "✅ Normal Operation")
        } ?: Text(text = "Loading...")
    }
}
