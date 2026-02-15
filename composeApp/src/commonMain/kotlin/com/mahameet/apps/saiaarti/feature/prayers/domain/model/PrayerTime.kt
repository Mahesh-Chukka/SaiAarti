package com.mahameet.apps.saiaarti.feature.prayers.domain.model

enum class PrayerTime(val id: String, val title: String, val subtitle: String) {
    MORNING("morning", "Morning", "Sunrise prayers"),
    AFTERNOON("afternoon", "Afternoon", "Midday prayers"),
    EVENING("evening", "Evening", "Sunset prayers"),
    NIGHT("night", "Night", "Night prayers");
}
