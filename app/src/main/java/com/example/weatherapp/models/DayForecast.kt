package com.example.weatherapp.models

import com.squareup.moshi.Json


data class DayForecastList(
    @Json(name = "dt") val forecastDate: Long,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
    @Json(name = "temp") val minMaxTemperature: ForecastTemp,
    @Json(name = "pressure") val pressure: Float,
    @Json(name = "humidity") val humidity: Int,
    @Json(name = "weather") val forecastImage: List<ForecastData>,

)
data class ForecastTemp(
    @Json(name = "min") val minTemperature: Float,
    @Json(name = "max") val maxTemperature: Float,
)

data class ForecastData(
    @Json(name = "icon") val iconName: String,
)

data class DayForecast(
    @Json(name = "list") val listData: List<DayForecastList>,
    )


