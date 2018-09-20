package com.example.kdl.weather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.util.*

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHER STATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList: RecyclerView = find(R.id.forecast_list)
        val progressBar: ProgressBar = find(R.id.progressbar)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        val f1 = Forecast(Date(), 27.5f, "Shiny day")
        val f2 = f1.copy(tempereture = 30f)
        val (date, temperature, details) = f1
        val map = mapOf<String, Int>("1" to 1, "2" to 2, "3" to 3)
        for ((key, value) in map) {
            Log.d("map", "key:$key,value:$value")
        }

        val url = "http://wanandroid.com/tools/mockapi/2192/get_news"
        async {
            Request(url).run()
            uiThread {
                longToast("Request performed")
                progressBar.visibility = View.GONE
            }
        }
    }
}
