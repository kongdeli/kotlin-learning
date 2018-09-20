package com.example.kdl.weather

import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.TextView

class ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
        holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}