package com.akshaylalsp.apistarter.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akshaylalsp.apistarter.viewmodel.MeterViewModel
import com.himanshoe.charty.bar.BarChart
import com.himanshoe.charty.bar.config.BarChartColorConfig
import com.himanshoe.charty.bar.config.BarChartConfig
import com.himanshoe.charty.bar.model.BarData
import com.himanshoe.charty.common.ChartColor
import com.himanshoe.charty.common.LabelConfig
import com.himanshoe.charty.line.LineChart
import com.himanshoe.charty.line.model.LineData

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun InsightsScreen(viewModel: MeterViewModel, modifier: Modifier = Modifier) {
    val barData by viewModel.barData.collectAsState() // Collect data from ViewModel

    Column(modifier = modifier.padding(16.dp)) {
        // Buttons to switch between Monthly, Weekly, and Daily data
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { viewModel.fetchMonthlyData() }) { Text("Monthly") }
            Button(onClick = { viewModel.fetchWeeklyData() }) { Text("Weekly") }
            Button(onClick = { viewModel.fetchDailyData() }) { Text("Daily") }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Bar Chart with Labels
        BarChart(
            data = { barData },
            modifier = Modifier.fillMaxWidth(),
            labelConfig = LabelConfig.default().copy(
// Y-axis label color
            ),
            barChartConfig = BarChartConfig.default().copy( // Show X-axis labels
            ),
            barChartColorConfig = BarChartColorConfig.default().copy(
//                fillBarColor = Color.Blue           // Change bar color
            )
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BarChartScreen(vm: MeterViewModel = viewModel()) {
//    vm.fetchMonthlyData()
    val barData = listOf(
        BarData(10F, "Jan"),
        BarData(20F, "Feb"),
        BarData(15F, "Mar"),
        BarData(25F, "Apr"),
        BarData(18F, "May")
    )



    val lindata by vm.barData.collectAsState()
    var data = lindata

//    println(lindata)

    val labelConfig = LabelConfig.default().copy(showXLabel = true, showYLabel = true)

    Column {
        Row {
            Button(onClick = { vm.fetchMonthlyData() }) { Text("Monthly") }
            Button(onClick = { vm.fetchWeeklyData() }) { Text("Weekly") }
            Button(onClick = { vm.fetchDailyData() }) { Text("Daily") }
        }
        Spacer(modifier = Modifier.height(20.dp))

        if (lindata.isNotEmpty()){
            println(lindata)
            println(barData)
            BarChart(
                data = { lindata },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                labelConfig = labelConfig,
                onBarClick = { index, barData ->
                    println("Clicked on: ${barData.xValue} with value: ${barData.yValue}")
                }
            )
        }
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

    }


}