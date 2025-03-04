package com.akshaylalsp.apistarter.models

data class LiveReading(
    val timestamp: String = "",
    val voltage: Double = 0.0,
    val power: Double = 0.0,
    val unitConsumed: Double = 0.0
)
