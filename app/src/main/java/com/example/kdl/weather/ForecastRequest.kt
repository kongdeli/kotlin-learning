package com.example.kdl.weather

import android.util.Log
import com.example.kdl.weather.data.ForecastResult
import com.google.gson.Gson
import java.net.URL

/**
 * Created by Dale on 2018/8/28.
 */
class ForecastRequest(val zipCode: String) {

    companion object {
        private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private const val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private const val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}