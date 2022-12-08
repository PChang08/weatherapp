package com.example.weatherapp.service

import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.DayForecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("id") apiKey: String = "5e816460d82b198caf779180a6b5de67",
        @Query("units") units: String = "imperial",
    ) : CurrentConditions


    @GET("data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("zip") zip: String,
        @Query("id") apiKey: String = "5e816460d82b198caf779180a6b5de67",
        @Query("cnt") cnt: String = "16",
        @Query("units") units: String = "imperial",
    ) : DayForecast

}