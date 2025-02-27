package com.akshaylalsp.apistarter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.himanshoe.charty.line.LineChart
import com.himanshoe.charty.line.model.LineData

@Composable
fun InsightsScreen(modifier: Modifier = Modifier) {
    var lindata = listOf(
        LineData(1F,1),
        LineData(4F,2),
        LineData(5F,3),
        LineData(73F,4),
        LineData(12F,5),
        LineData(16F,6)

    )
    Column {
        Row {
            Button(onClick = {}) { Text("Montly") }
            Button(onClick = {}) { Text("Weekly") }
            Button(onClick = {}) { Text("Daily") }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LineChart(
            data = {lindata},
            showFilledArea = true
        )
    }
}