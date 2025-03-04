package com.akshaylalsp.apistarter.repository

import com.akshaylalsp.apistarter.meterapiserver.BillPrediction
import com.akshaylalsp.apistarter.meterapiserver.DailyMeterReading
import com.akshaylalsp.apistarter.meterapiserver.MeterApi
import com.akshaylalsp.apistarter.meterapiserver.MonthlyMeterReading
import com.akshaylalsp.apistarter.meterapiserver.WeeklyMeterReading


class MeterRepository(private val api: MeterApi) {

    suspend fun getMonthlyData(meterId: String): List<MonthlyMeterReading>? {
        return try {
            val response = api.monthlydata(meterId)
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null  // Handle error
        }
    }

    suspend fun getWeeklyData(meterId: String): List<WeeklyMeterReading>? {
        return try {
            val response = api.weeklydata(meterId)
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getDailyData(meterId: String): List<DailyMeterReading>? {
        return try {
            val response = api.dailydata(meterId)
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }
    suspend fun getPredictBill(meterId: String): BillPrediction? {
        return try {
            val response = api.predictbill(meterId)
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }

}
