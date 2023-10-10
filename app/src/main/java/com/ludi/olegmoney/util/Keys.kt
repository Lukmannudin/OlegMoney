package com.ludi.olegmoney.util

object Keys {
    init {
        System.loadLibrary("native-lib")
    }

    external fun baseUrl(): String
}