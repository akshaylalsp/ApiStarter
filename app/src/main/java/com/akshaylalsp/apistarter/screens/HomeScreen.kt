package com.akshaylalsp.apistarter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {}) {
            Text("LiveData")
        }
        Button(onClick = {}) {
            Text("Insights")
        }
        Button(onClick = {}) {
            Text("Predict Bill")
        }
        Button(onClick = {}) {
            Text("Bill Payment")
        }

    }
}