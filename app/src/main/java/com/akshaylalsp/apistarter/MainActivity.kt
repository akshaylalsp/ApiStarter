package com.akshaylalsp.apistarter

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akshaylalsp.apistarter.api.RetrofitInstance
import com.akshaylalsp.apistarter.meterapiserver.RetrofitApiInstance
import com.akshaylalsp.apistarter.repository.MeterRepository
import com.akshaylalsp.apistarter.screens.AnomalyDetectionScreen
import com.akshaylalsp.apistarter.screens.BarChartScreen
import com.akshaylalsp.apistarter.screens.HomeScreen
import com.akshaylalsp.apistarter.screens.InsightsScreen
import com.akshaylalsp.apistarter.screens.PeakUsageScreen
import com.akshaylalsp.apistarter.screens.RealTimeMonitoringScreen
import com.akshaylalsp.apistarter.ui.theme.ApiStarterTheme
import com.akshaylalsp.apistarter.viewmodel.MeterViewModel
import com.google.firebase.database.FirebaseDatabase
import com.himanshoe.charty.bar.BarChart
import com.himanshoe.charty.bar.model.BarData
import com.himanshoe.charty.common.ChartColor
import com.himanshoe.charty.common.LabelConfig

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        val viewModel: WeatherViewModel by viewModels()
        val rep = MeterRepository(RetrofitApiInstance.api)
        val vm = MeterViewModel(rep)
        enableEdgeToEdge()
        setContent {
            ApiStarterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    BarChartScreen(vm)
//                    RealTimeMonitoringScreen(1,1)
//                    PeakUsageScreen(1)
//                    AnomalyDetectionScreen(1)
                    HomeScreen(
                        modifier = Modifier,
                        cluster_id = 1,
                        meter_id = 1
                    )

                }
            }
        }
    }
}

//@Composable
//fun Greeting() {
//    val repository = MeterRepository(
//        api = RetrofitApiInstance.api
//    )
//    val vm = remember { MeterViewModel(repository) }
//    vm.fetchDailyData("SM1")
//    val daily = vm.dailyData.collectAsState()
//    val weekly = vm.weeklyData.collectAsState()
//    val montly = vm.monthlyData.collectAsState()
//    println(daily.value)
//    Log.i("test", daily.value.toString())
//
//    Column {
//        daily.value.forEach { item->
//            Text(item.toString())
//        }
//    }
//
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ApiStarterTheme {
////        Greeting("Android")
//    }
//}



