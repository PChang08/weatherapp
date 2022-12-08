package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ForecastAdapter(private val data: List<Forecast>) : RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_forecast_item, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val forecastTemp: TextView

    init {
        forecastTemp = view.findViewById(R.id.forecast_temp)
    }

    fun bind(data: Forecast){
        forecastTemp.text = data.temp
    }
}