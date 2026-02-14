package com.mahameet.apps.saiaarti.feature.prayers.presentation

sealed class PrayersStep {
    data object Language : PrayersStep()
    data object Time : PrayersStep()
    data object Pdf : PrayersStep()
}
