package com.example.mshadrin.weatherapp


import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.mshadrin.weatherapp.domain.ForecastList

class ForecastlistAdapter(val list: ForecastList) : RecyclerView.Adapter<ForecastlistAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(list.dailyForecast[position]){
            holder.view.text = "$date - $description - $high/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(TextView(parent.context))

    override fun getItemCount(): Int = list.dailyForecast.size

    class ViewHolder(val view : TextView) : RecyclerView.ViewHolder(view)
}