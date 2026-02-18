package com.mahameet.apps.saiaarti.version

expect fun currentPlatform(): Platform

enum class Platform {
    ANDROID,
    IOS,
    OTHER
}