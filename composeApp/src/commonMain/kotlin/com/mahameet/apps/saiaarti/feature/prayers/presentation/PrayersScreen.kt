package com.mahameet.apps.saiaarti.feature.prayers.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.mahameet.apps.saiaarti.feature.prayers.presentation.screens.LanguageScreen
import com.mahameet.apps.saiaarti.feature.prayers.presentation.screens.PdfPathScreen
import com.mahameet.apps.saiaarti.feature.prayers.presentation.screens.TimeScreen
import org.koin.compose.koinInject

@Composable
fun PrayersScreen() {
    val vm = koinInject<PrayersViewModel>()
    val state = vm.state.collectAsState().value

    when (state.step) {
        PrayersStep.Language -> LanguageScreen(
            languages = vm.languages,
            onSelect = vm::selectLanguage
        )
        PrayersStep.Time -> TimeScreen(
            language = state.selectedLanguage!!,
            times = vm.prayerTimes(state.selectedLanguage!!),
            onSelect = vm::selectTime,
            onBack = vm::back
        )
        PrayersStep.Pdf -> PdfPathScreen(
            language = state.selectedLanguage!!,
            time = state.selectedTime!!,
            path = state.pdfPath ?: "",
            isLoading = state.isLoading,
            error = state.error,
            onBack = vm::back
        )
    }
}
