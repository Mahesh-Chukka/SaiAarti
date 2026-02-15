package com.mahameet.apps.saiaarti.feature.prayers.domain.model

enum class PrayerTime(val id: String) {
    MORNING("morning"),
    AFTERNOON("afternoon"),
    EVENING("evening"),
    NIGHT("night");

    val ritualName: String
        get() = when (this) {
            MORNING -> "Kakad"
            AFTERNOON -> "Madhyan"
            EVENING -> "Dhoop"
            NIGHT -> "Shej"
        }
}