package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.CurrentConditions
import com.example.weatherapp.ui.ForecastScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "CurrentConditions"){
                composable("CurrentConditions"){
                    CurrentConditions {
                        navController.navigate("Forecast")
                    }
                }

                composable("Forecast"){
                    ForecastScreen()
                }
            }
        }
    }
}