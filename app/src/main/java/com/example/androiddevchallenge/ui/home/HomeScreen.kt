package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(openDetails: (String) -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Row(Modifier.padding(8.dp)) {
            Button(onClick = {openDetails("Clara")}){ Text(text = "Clara") }
        }
        Row(Modifier.padding(8.dp)) {
            Button(onClick = {openDetails("Snow")}){ Text(text = "Snow") }
        }
        Row(Modifier.padding(8.dp)) {
            Button(onClick = {openDetails("Snow")}){ Text(text = "Snow") }
        }
    }
}