package com.mahameet.apps.saiaarti.feature.prayers.domain.repository

import com.mahameet.apps.saiaarti.feature.prayers.domain.model.Language
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.PrayerTime

interface PrayerRepository {

    fun getAvailableLanguages(): List<Language>

    fun getPrayerTimes(language: Language): List<PrayerTime>

    suspend fun getLocalPdfPath(
        language: Language,
        prayerTime: PrayerTime
    ): String
}
