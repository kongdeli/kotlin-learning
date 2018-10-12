package com.example.kdl.weather.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kdl.weather.R
import com.example.kdl.weather.domain.model.ForeCastList
import com.example.kdl.weather.domain.model.Forecast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forcast.view.*

class ForecastListAdapter(val weekForecast: ForeCastList, val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forcast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

//    interface OnItemClickListener {
//
//        operator fun invoke(forcast: Forecast)
//    }

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

//        private val iconView: ImageView = view.find(R.id.icon)
//        private val dateView: TextView = view.find(R.id.date)
//        private val descriptionView: TextView = view.find(R.id.description)
//        private val maxTemperatureView: TextView = view.find(R.id.maxTemperature)
//        private val minTemperatureView: TextView = view.find(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.get().setIndicatorsEnabled(true)
                Picasso.get().load(iconUrl).placeholder(R.mipmap.ic_launcher).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener {
                    itemClick(forecast)
                }
            }
        }
    }
}
