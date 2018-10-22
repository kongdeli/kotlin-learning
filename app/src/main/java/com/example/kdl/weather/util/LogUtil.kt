package com.example.kdl.weather.util

object LogUtil {
    enum class LogLevel {
        ERROR {
            override val value: Int
                get() = 0

        },
        WARN {
            override val value: Int
                get() = 1
        },
        INFO {
            override val value: Int
                get() = 2
        },
        DEBUG {
            override val value: Int
                get() = 3
        };

        abstract val value: Int
    }

    private var TAG = "KONG_DL"
    var logLevel = LogLevel.DEBUG
    @JvmStatic
    fun init(clazz: Class<*>) {
        TAG = clazz.simpleName
    }

    @JvmStatic
    fun init(tag: String) {
        TAG = tag
    }

    @JvmStatic
    fun e(msg: String) {
        if (LogLevel.ERROR.value <= logLevel.value) {
            if (msg.isNotBlank()) {
                val s = getMethodNames()
            }
        }
    }

    private fun getMethodNames(): String {
        return ""
    }
}