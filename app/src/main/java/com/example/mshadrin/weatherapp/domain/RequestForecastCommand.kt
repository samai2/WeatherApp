package com.example.mshadrin.weatherapp.domain

import com.example.mshadrin.weatherapp.data.ForecastRequest

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastResult = ForecastRequest(zipCode).execute()
        return ForecastDataMapper().convertFromDataModel(forecastResult)
    }
}