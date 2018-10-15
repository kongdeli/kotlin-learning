package com.example.kdl.weather

import android.content.Context
import android.widget.Toast
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty

/**
 * Created by Dale on 2018/8/28.
 */


fun Context.toast(msg: CharSequence = "default msg", duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun <T : Any> Delegates.notNullSingleInit(): ReadWriteProperty<Any?, T> = NotNullSingleInitVar()