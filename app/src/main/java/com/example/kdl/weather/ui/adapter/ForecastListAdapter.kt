package com.example.kdl.weather.ui.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kdl.weather.R
import com.example.kdl.weather.domain.model.ForeCastList
import com.example.kdl.weather.domain.model.Forecast
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import java.lang.Exception

class ForecastListAdapter(val weekForecast: ForeCastList, val itemClick: OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forcast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    public interface OnItemClickListener {

        operator fun invoke(forcast: Forecast)
    }

    class ViewHolder(view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView = view.find(R.id.icon)
        private val dateView: TextView = view.find(R.id.date)
        private val descriptionView: TextView = view.find(R.id.description)
        private val maxTemperatureView: TextView = view.find(R.id.maxTemperature)
        private val minTemperatureView: TextView = view.find(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.get().setIndicatorsEnabled(true)
                Picasso.get().load(iconUrl).placeholder(R.mipmap.ic_launcher_round).into(iconView,
                        object : Callback {
                            override fun onSuccess() {
                            }

                            override fun onError(e: Exception?) {
                                Log.e("picLoadFail", e.toString())
                            }

                        })
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener {
                    itemClick(forecast)
                }
            }
        }
    }
}
