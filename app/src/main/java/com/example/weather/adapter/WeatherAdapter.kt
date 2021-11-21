package com.example.weather.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.GetCountryName
import com.example.weather.R

class WeatherAdapter(
    private val weatherList: List<GetCountryName>,
    private val context: Context
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherNameCountry: GetCountryName = weatherList[position]

        holder.tvCountryName.text = weatherNameCountry.name
        holder.textViewLat.text = weatherNameCountry.coord?.lat.toString()
        holder.textViewLon.text = weatherNameCountry.coord?.lon.toString()
        holder.textViewCountryId.text = weatherNameCountry.id.toString()

    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCountryName: TextView = itemView.findViewById(R.id.tvCountryName)
        val textViewLat: TextView = itemView.findViewById(R.id.textViewLat)
        val textViewLon: TextView = itemView.findViewById(R.id.textViewLon)
        val textViewCountryId: TextView = itemView.findViewById(R.id.textViewCountryId)

    }
}