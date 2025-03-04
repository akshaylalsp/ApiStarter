package com.akshaylalsp.apistarter.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshaylalsp.apistarter.meterapiserver.DailyMeterReading
import com.akshaylalsp.apistarter.meterapiserver.MonthlyMeterReading
import com.akshaylalsp.apistarter.meterapiserver.WeeklyMeterReading
import com.akshaylalsp.apistarter.repository.MeterRepository
import com.himanshoe.charty.bar.model.BarData
import com.himanshoe.charty.common.ChartColor
import com.himanshoe.charty.line.model.LineData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

//class MeterViewModel(private val repository: MeterRepository) : ViewModel() {
//
//    private val _monthlyData = MutableStateFlow<List<MonthlyMeterReading>>(emptyList())
//    val monthlyData: StateFlow<List<MonthlyMeterReading>> = _monthlyData
//
//    private val _weeklyData = MutableStateFlow<List<WeeklyMeterReading>>(emptyList())
//    val weeklyData: StateFlow<List<WeeklyMeterReading>> = _weeklyData
//
//    private val _dailyData = MutableStateFlow<List<DailyMeterReading>>(emptyList())
//    val dailyData: StateFlow<List<DailyMeterReading>> = _dailyData
//
//    fun fetchMonthlyData(meterId: String) {
//        viewModelScope.launch {
//            repository.getMonthlyData(meterId)?.let { _monthlyData.value = it }
//        }
//    }
//
//    fun fetchWeeklyData(meterId: String) {
//        viewModelScope.launch {
//            repository.getWeeklyData(meterId)?.let { _weeklyData.value = it }
//        }
//    }
//
//    fun fetchDailyData(meterId: String) {
//        viewModelScope.launch {
//            repository.getDailyData(meterId)?.let { _dailyData.value = it }
//        }
//    }
//}
@RequiresApi(Build.VERSION_CODES.O)
class MeterViewModel(private val repository: MeterRepository) : ViewModel() {
    private val _barData = MutableStateFlow<List<BarData>>(emptyList())
    val barData: StateFlow<List<BarData>> = _barData.asStateFlow()

    init {
        fetchDailyData()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchMonthlyData() {
        viewModelScope.launch {
            val response = repository.getMonthlyData("SM1")
            if (response != null) {
                _barData.value = response.map {
                    BarData(
                        yValue = it.total_units.toFloat(),
                        xValue = it.month.toString(), // ✅ Convert timestamp to string
                        barColor = ChartColor.Solid(Color.Blue),
                        barBackgroundColor = ChartColor.Solid(Color.LightGray)
                    )
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchWeeklyData() {
        viewModelScope.launch {
            val response = repository.getWeeklyData("SM1")
            if (response != null) {
                _barData.value = response.map {
                    BarData(
                        yValue = it.avg_consumption.toFloat(),
                        xValue = formatDate(it.week_start), // ✅ Convert to string
                        barColor = ChartColor.Solid(Color.Green),
                        barBackgroundColor = ChartColor.Solid(Color.LightGray)
                    )
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchDailyData() {
        viewModelScope.launch {
            val response = repository.getDailyData("SM1")
            if (response != null) {
                _barData.value = response.map {
                    BarData(
                        yValue = it.reading.toFloat(),
                        xValue = formatDate(it.date), // ✅ Convert to string
                        barColor = ChartColor.Solid(Color.Red),
                        barBackgroundColor = ChartColor.Solid(Color.LightGray)
                    )
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatDate(dateString: String): String {
        return try {
            val inputFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME // For input like 2025-02-01T17:49:11.628708Z
            val outputFormatter = DateTimeFormatter.ofPattern("MMM dd") // Output as "Feb 01"
            val date = OffsetDateTime.parse(dateString, inputFormatter)
            date.format(outputFormatter)
        } catch (e: Exception) {
            "Invalid Date"
        }
    }
}


class MeterViewModell(private val repository: MeterRepository) : ViewModel() {
    private val _barData = MutableStateFlow<List<BarData>>(listOf(BarData(0F, "Loading...")))
    val barData: StateFlow<List<BarData>> = _barData.asStateFlow()

    init {
        fetchDailyData()
    }

    fun fetchMonthlyData() {
        viewModelScope.launch {
            val response = repository.getMonthlyData("SM1") // Fetch from API
            if (response != null) {
                _barData.value = response.map {
                    BarData(
                        yValue = it.total_units.toFloat(), // Value of the bar
                        xValue = it.month.toString() // X-axis label (e.g., "Jan", "Feb")
                    )
                }
            }
        }
    }

    fun fetchWeeklyData() {
        viewModelScope.launch {
            val response = repository.getWeeklyData("SM1")
            if (response != null) {
                _barData.value = response.map {
                    BarData(
                        yValue = it.avg_consumption.toFloat(), // Avg consumption as bar height
                        xValue = "Week ${it.week_start}" // X-axis label (e.g., "Week 1")
                    )
                }
            }
        }
    }

    fun fetchDailyData() {
        viewModelScope.launch {
            val response = repository.getDailyData("SM1")
            if (response != null) {
                _barData.value = response.map {
                    BarData(
                        yValue = it.reading.toFloat(), // Daily reading
                        xValue = it.date // X-axis label (e.g., "2025-03-01")
                    )
                }
            }
        }
    }
}
