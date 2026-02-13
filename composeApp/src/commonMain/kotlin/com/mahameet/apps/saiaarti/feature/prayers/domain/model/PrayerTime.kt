package com.mahameet.apps.saiaarti.feature.prayers.domain.model

enum class PrayerTime(val id: String, val displayName: String) {
    MORNING("morning", "Morning"),
    AFTERNOON("afternoon", "Afternoon"),
    EVENING("evening", "Evening"),
    NIGHT("night", "Night");
}