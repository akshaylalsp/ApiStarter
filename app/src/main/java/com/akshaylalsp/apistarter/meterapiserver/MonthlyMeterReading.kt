package com.akshaylalsp.apistarter.meterapiserver

data class MonthlyMeterReading(
    val id: Int,
    val meter: String,
    val month: Int,
    val total_units: Double,
    val year: Int
)