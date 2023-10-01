package com.lukmannudin.sharedkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform