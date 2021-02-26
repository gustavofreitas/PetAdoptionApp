package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(message: String, navigateBack: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Row{
            Text(text = message)
        }
        Row {
           Button(onClick = { navigateBack() }) {
               Text(text = "Back")
           } 
        }
    }
}