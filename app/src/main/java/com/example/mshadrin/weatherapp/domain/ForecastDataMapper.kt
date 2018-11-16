package com.example.mshadrin.weatherapp.domain


import com.example.mshadrin.weatherapp.data.Forecast
import com.example.mshadrin.weatherapp.data.ForecastResult
import java.text.DateFormat.DEFAULT
import java.text.DateFormat.getDateInstance
import java.util.*

import com.example.mshadrin.weatherapp.domain.Forecast as ModelForecast

class ForecastDataMapper {
    fun convertFromDataModel(forecastResult: ForecastResult): ForecastList {

        return ForecastList(forecastResult.city.name, forecastResult.city.country, getListOfForecast(forecastResult.list))
    }

    private fun getListOfForecast(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast -> convertForecastRestItem(forecast) }
    }

    private fun convertForecastRestItem(item : Forecast) : ModelForecast{
        return  ModelForecast(convertDate(item.dt), item.weather.first().description, item.temp.max.toInt(), item.temp.min.toInt())
    }
    private fun convertDate(date: Long): String {
        return getDateInstance(DEFAULT, Locale.getDefault()).format(date * 1000L)
    }




}