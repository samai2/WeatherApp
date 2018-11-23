package com.example.mshadrin.weatherapp


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.mshadrin.weatherapp.domain.Forecast
import com.example.mshadrin.weatherapp.domain.ForecastList
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: ForecastListAdapter.OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(weekForecast[position]){
         holder.bindForecast(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view , itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(val view : View, val itemClick: ForecastListAdapter.OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateVies = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView =  view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView =  view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.get().load(iconUrl).into(iconView)
                dateVies.text = description
                maxTemperatureView.text="$high"
                minTemperatureView.text="$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}
