package com.example.kdl.weather.domain.model

data class ForeCastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {
    operator fun get(position: Int) = dailyForecast[position]
    fun size() = dailyForecast.size
}

data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)