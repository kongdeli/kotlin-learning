package com.example.kdl.weather

import android.content.Context
import android.widget.Toast

/**
 * Created by Dale on 2018/8/28.
 */
fun Context.toast(msg: CharSequence = "default msg", duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}