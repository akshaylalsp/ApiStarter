package com.akshaylalsp.apistarter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

@Composable
fun HomeScreen(modifier: Modifier = Modifier,cluster_id :Int,meter_id:Int){
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        Card(onClick = {}, modifier = Modifier){
            RealTimeMonitoringScreen(clusterId = cluster_id, meterId = meter_id)
        }
        Card(onClick = {}, modifier = Modifier){
            PredictBillScreen()
        }
        Card(onClick = {  }, modifier = Modifier){
            Text(text = "Usage Insights")
        }
//        Card(onClick = {}, modifier = Modifier){
//            RealTimeMonitoringScreen(clusterId = cluster_id, meterId = meter_id)
//        }


    }
}