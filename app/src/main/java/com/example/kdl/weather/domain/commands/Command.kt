package com.example.kdl.weather.domain.commands

import com.example.kdl.weather.ForecastRequest
import com.example.kdl.weather.domain.ForecastDataMapper
import com.example.kdl.weather.domain.model.ForeCastList

interface Command<out T> {
    fun execute(): T
}

class RequestForecastCommand(val zipCode: String) : Command<ForeCastList> {
    override fun execute(): ForeCastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute()
        )
    }

}