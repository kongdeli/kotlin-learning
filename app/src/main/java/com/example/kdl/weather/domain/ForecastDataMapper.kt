package com.example.kdl.weather.domain

import com.example.kdl.weather.data.Forecast
import com.example.kdl.weather.data.ForecastResult
import com.example.kdl.weather.domain.model.ForeCastList
import java.text.DateFormat
import java.util.*
import com.example.kdl.weather.domain.model.Forecast as ModelForecast

public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForeCastList {
        return ForeCastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}