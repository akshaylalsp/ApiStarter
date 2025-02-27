package com.akshaylalsp.apistarter.meterapiserver

data class DailyMeterReading(
    val date: String,
    val id: Int,
    val meter: String,
    val reading: Double
)