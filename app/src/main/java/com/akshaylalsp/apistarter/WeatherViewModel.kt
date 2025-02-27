package com.akshaylalsp.apistarter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshaylalsp.apistarter.api.ApiResponse
import com.akshaylalsp.apistarter.api.Constant
import com.akshaylalsp.apistarter.api.NetworkResponse
import com.akshaylalsp.apistarter.api.RetrofitInstance
import com.akshaylalsp.apistarter.api.WeatherApi
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    val api:WeatherApi = RetrofitInstance.api
    private  val _weatherdata = MutableLiveData<NetworkResponse<ApiResponse>>()
    val weatherdata : LiveData<NetworkResponse<ApiResponse>> = _weatherdata
    fun getData(city:String){
        viewModelScope.launch {
            _weatherdata.value = NetworkResponse.Loading
            val response = api.getWeather(key = Constant.key, location = city)
            if (response.isSuccessful){
                Log.i("api","${response.body()}")
                response.body()?.let {
                    _weatherdata.value = NetworkResponse.Success(it)
                }
            }
            else{
                _weatherdata.value = NetworkResponse.Error("failed to load")
                Log.i("api","${response.errorBody()}")
            }
        }
    }
}