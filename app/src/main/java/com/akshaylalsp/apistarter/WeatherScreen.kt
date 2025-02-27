package com.akshaylalsp.apistarter

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akshaylalsp.apistarter.api.NetworkResponse

@Composable
fun HomeScreen(modifier: Modifier = Modifier,viewModel: WeatherViewModel){

    var text by remember { mutableStateOf("") }
    val weatherresult = viewModel.weatherdata.observeAsState()

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        OutlinedTextField(value = text, onValueChange = {text = it})
        IconButton(onClick = { viewModel.getData(text) }) {
            Image(imageVector = Icons.Filled.Search,"")
        }
    }

    when(val result = weatherresult.value){
        is NetworkResponse.Error -> {
            Text(text = result.message  )
        }
        NetworkResponse.Loading -> {
            CircularProgressIndicator()
        }
        is NetworkResponse.Success -> {
            Text(text = result.data.toString())
        }

        null -> {
            CircularProgressIndicator()
        }
    }
}

//@Preview
//@Composable
//fun HomeScreenPreview(){
//    HomeScreen(viewModel = vi)
//}