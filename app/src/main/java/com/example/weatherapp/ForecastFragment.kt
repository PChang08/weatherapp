package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.FragmentForecastBinding
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()
    private val data: List<Forecast> = (0..100).map { Forecast(it.toString())}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(data)

        val dataTimeStamp = 1670246929L
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val dateTime = LocalDateTime.ofEpochSecond(dataTimeStamp, 0, ZoneOffset.of("-5"))
        val formattedDate = formatter.format(dateTime)

        val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")
        val formattedTime = timeFormatter.format(dateTime)

        val tempString = resources.getString(R.string.degree_temp, 70)
        Log.d("ForecastFragment", formattedDate)
        Log.d("ForecastFragment", formattedTime)
    }
}