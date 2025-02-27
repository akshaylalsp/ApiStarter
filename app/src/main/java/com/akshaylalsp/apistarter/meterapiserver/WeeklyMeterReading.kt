package com.akshaylalsp.apistarter.meterapiserver

data class WeeklyMeterReading(
    val avg_consumption: Double,
    val id: Int,
    val meter: String,
    val week_start: String
)