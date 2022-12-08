package com.example.weatherapp.ui
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.models.DayForecast
import com.example.weatherapp.models.DayForecastList
import com.example.weatherapp.toHourMinute
import com.example.weatherapp.toMonthDay


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
    ) {
    val state by viewModel.dayForecast.collectAsState(null)

    LaunchedEffect(Unit){
        viewModel.fetchData()
    }
    Scaffold(
        topBar = { Appbar(title = stringResource(id = R.string.forecast)) },
    ) {
        state?.let {
            ForecastContent(it)
        }
    }
}

@Composable
private fun ForecastContent(
    dayForecast: DayForecast,
) {
    LazyColumn {
        items(items = dayForecast.listData) { item: DayForecastList ->
            ForecastRow(item = item)
        }
    }
}

@Composable
private fun ForecastRow(item: DayForecastList){
    Row(
        modifier = Modifier.padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val textStyle = TextStyle(
            fontSize = 12.sp,
        )

        AsyncImage(
            model = String.format("https://openweathermap.org/img/wn/%s@2x.png", item.forecastImage.firstOrNull()?.iconName),
            contentDescription = "")
        Spacer(modifier = Modifier.weight(.6f, fill = true))
        Text(
            text = item.forecastDate.toMonthDay(),
            style = TextStyle(
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.weight(2f, fill = true))
        Column() {
            Text(
                text = stringResource(id = R.string.high, item.minMaxTemperature.maxTemperature.toInt()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.low, item.minMaxTemperature.minTemperature.toInt()),
                style = textStyle,
            )
        }
        Spacer(modifier = Modifier.weight(2f, fill = true))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = stringResource(id = R.string.sunrise, item.sunrise.toHourMinute()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.sunset, item.sunset.toHourMinute()),
                style = textStyle,
            )

        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
private fun ForecastRowPreview() {

}