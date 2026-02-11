package com.mahameet.apps.saiaarti

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform