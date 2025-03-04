package com.akshaylalsp.apistarter.models

data class AnomalyDetection(
    val anomaly: Boolean = false,
    val activeMeters: Int = 0,
    val totalMeters: Int = 0
)

