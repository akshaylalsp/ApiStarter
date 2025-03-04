package com.akshaylalsp.apistarter.meterapiserver

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MeterApi {
    @GET("/c/monthly/")
    suspend fun monthlydata(@Query("meter_id") meter_id:String = "SM1"):Response<List<MonthlyMeterReading>>
    @GET("/c/weekly/")
    suspend fun weeklydata(@Query("meter_id") meter_id:String = "SM1"):Response<List<WeeklyMeterReading>>
    @GET("/c/daily/")
    suspend fun dailydata(@Query("meter_id") meter_id:String = "SM1"):Response<List<DailyMeterReading>>
    @GET("/c/predict-bill/{meter_id}/")
    suspend fun predictbill(@Path("meter_id") meter_id:String = "SM1"):Response<BillPrediction>

}