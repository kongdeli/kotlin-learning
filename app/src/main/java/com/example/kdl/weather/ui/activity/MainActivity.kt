package com.example.kdl.weather.ui.activity

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.example.kdl.weather.R
import com.example.kdl.weather.domain.commands.RequestForecastCommand
import com.example.kdl.weather.toast
import com.example.kdl.weather.ui.adapter.ForecastListAdapter
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList: RecyclerView = find(R.id.forecast_list)
        val progressBar: ProgressBar = find(R.id.progressbar)
        forecastList.layoutManager = LinearLayoutManager(this)

        async {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                progressBar.visibility = View.GONE
                forecastList.adapter = ForecastListAdapter(result) { forecast -> toast(forecast.date) }
            }
        }

        supportsLollipop {

        }
    }

    inline fun supportsLollipop(code: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            code()
        }
    }
}
