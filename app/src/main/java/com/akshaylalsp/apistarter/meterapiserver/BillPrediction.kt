package com.akshaylalsp.apistarter.meterapiserver

data class BillPrediction(
    val estimated_bill: Double,
    val meter_id: String,
    val predicted_monthly_units: Double
)