package com.example.kdl.weather

import android.app.Application
import com.example.kdl.Configuration

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val conf = Configuration(mapOf(
                "width" to 1080,
                "height" to 720,
                "dp" to 240,
                "deviceName" to "HTC"
        ))
    }
}