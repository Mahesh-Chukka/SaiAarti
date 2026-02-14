package com.mahameet.apps.saiaarti.feature.prayers.presentation

import com.mahameet.apps.saiaarti.feature.prayers.domain.model.Language
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.PrayerTime

data class PrayersState(
    val step: PrayersStep = PrayersStep.Language,
    val selectedLanguage: Language? = null,
    val selectedTime: PrayerTime? = null,
    val pdfPath: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
