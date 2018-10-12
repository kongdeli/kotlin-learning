package com.example.kdl.weather.ui.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.kdl.weather.R
import com.example.kdl.weather.domain.commands.RequestForecastCommand
import com.example.kdl.weather.toast
import com.example.kdl.weather.ui.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)

        async {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                progressBar.visibility = View.GONE
                forecastList.adapter = ForecastListAdapter(result) { forecast -> toast(forecast.date) }
            }
        }

        supportsLollipop {
            window.statusBarColor = Color.BLUE
        }
    }

    private inline fun supportsLollipop(code: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            code()
        }
    }
}
