package com.mahameet.apps.saiaarti.feature.prayers.domain.usecase

import com.mahameet.apps.saiaarti.feature.prayers.domain.repository.PrayerRepository

class GetAvailableLanguagesUseCase(
    private val repository: PrayerRepository
) {
    operator fun invoke() = repository.getAvailableLanguages()
}