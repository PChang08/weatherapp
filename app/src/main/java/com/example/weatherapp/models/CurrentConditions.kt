package com.example.weatherapp.models

import com.squareup.moshi.Json

data class WeatherData(
    @Json(name = "icon") val iconName: String,
)

data class CurrentConditionsData(
    @Json(name = "temp") val temperature: Float,
    @Json(name = "feels_like") val feelsLike: Float,
    @Json(name = "temp_min") val minTemperature: Float,
    @Json(name = "temp_max") val maxTemperature: Float,
    @Json(name = "pressure") val pressure: Float,
    @Json(name = "humidity") val humidity: Float,
)

data class CurrentConditions(
    @Json(name = "weather") val weatherData: List<WeatherData>,
    @Json(name = "main") val conditions: CurrentConditionsData,
)
