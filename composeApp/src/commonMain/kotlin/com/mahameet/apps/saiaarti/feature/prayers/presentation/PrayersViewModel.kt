package com.mahameet.apps.saiaarti.feature.prayers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.Language
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.PrayerTime
import com.mahameet.apps.saiaarti.feature.prayers.domain.repository.PrayerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PrayersViewModel(
    private val repository: PrayerRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PrayersState())
    val state: StateFlow<PrayersState> = _state

    val languages: List<Language> get() = repository.getAvailableLanguages()
    fun prayerTimes(language: Language) = repository.getPrayerTimes(language)

    fun selectLanguage(language: Language) {
        _state.update {
            it.copy(
                selectedLanguage = language,
                step = PrayersStep.Time,
                selectedTime = null,
                pdfPath = null,
                error = null
            )
        }
    }

    fun selectTime(time: PrayerTime) {
        val language = _state.value.selectedLanguage ?: return

        _state.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            runCatching {
                repository.getLocalPdfPath(language, time)
            }.onSuccess { path ->
                _state.update {
                    it.copy(
                        selectedTime = time,
                        pdfPath = path,
                        step = PrayersStep.Pdf,
                        isLoading = false
                    )
                }
            }.onFailure { e ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Failed to load PDF"
                    )
                }
            }
        }
    }

    fun back() {
        _state.update { current ->
            when (current.step) {
                PrayersStep.Language -> current
                PrayersStep.Time -> current.copy(step = PrayersStep.Language, selectedLanguage = null)
                PrayersStep.Pdf -> current.copy(step = PrayersStep.Time, pdfPath = null, selectedTime = null)
            }
        }
    }
}
