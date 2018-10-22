package com.example.kdl.weather

import android.util.Log

class Test {
    fun run() {
        val list = listOf(1, 2, 2, 4, 5, 6)
        list.forEach { Log.d("fold---", it.toString()) }
        Log.d("fold---", list.foldRight(4) { total, next -> total + next }.toString())
        list.forEachIndexed { index, value -> Log.d("fold---", "Position $index contains a $value.") }
        list.max()
        Log.d("fold---",list.maxBy { -it }.toString())
        list.flatMap { listOf(it) }
        
    }
}