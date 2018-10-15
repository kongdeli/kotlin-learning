package com.example.kdl.weather

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class NotNullSingleInitVar<T : Any>() : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
                ?: throw IllegalStateException("Property ${property.name} should be initialized before get.")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (null == this.value) this.value = value
        else throw IllegalStateException("Property ${property.name} already initialized.")
    }
}