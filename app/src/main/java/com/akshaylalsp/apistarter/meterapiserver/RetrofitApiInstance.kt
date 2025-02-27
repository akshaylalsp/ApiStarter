package com.akshaylalsp.apistarter.meterapiserver

import com.akshaylalsp.apistarter.api.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApiInstance {
    private const val baseurl = "https://api.weatherapi.com"

    private fun getinstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api = getinstance().create(WeatherApi::class.java)
}
