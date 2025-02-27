package com.akshaylalsp.apistarter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(modifier: Modifier=Modifier){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(value = username, onValueChange = {username=it})
        OutlinedTextField(value = password, onValueChange = {password=it})
        Row {
            Button(onClick = {}) {
                Text("Login")
            }
        }
    }
}