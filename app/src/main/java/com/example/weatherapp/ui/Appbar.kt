package com.example.weatherapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Appbar(title: String){
    TopAppBar(
        backgroundColor = Color.Blue
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 18.dp),
            text = title,
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight(800)
            )
            )
    }
}

@Preview
@Composable
fun AppBarPreview(){
    Appbar(title = "WeatherApp")
}