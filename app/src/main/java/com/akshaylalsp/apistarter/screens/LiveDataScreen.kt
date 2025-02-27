package com.akshaylalsp.apistarter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshoe.charty.line.LineChart
import com.himanshoe.charty.line.model.LineData

@Composable
fun LiveDataScreen(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize()) {
        var lindata = listOf<LineData>(
            LineData(1F,1),
            LineData(4F,2),
            LineData(5F,3),
            LineData(73F,4),
            LineData(12F,5),
            LineData(16F,6)

        )
        Text("Readings here")

        Spacer(modifier = modifier.height(20.dp))

        LineChart(
            data = {lindata},
            showFilledArea = true
        )
    }
}

@Preview
@Composable
fun preview(){
//    LiveDataScreen()
//    LoginScreen()
////    HomeScreen()
    PredictBillScreen()
}