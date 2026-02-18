package com.mahameet.apps.saiaarti.version

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VersionViewModel(
    private val checkUseCase: VersionCheckUseCase
) : ViewModel() {

    private val _forceUpdate = MutableStateFlow(false)
    val forceUpdate: StateFlow<Boolean> = _forceUpdate

    private val _optionalUpdate = MutableStateFlow(false)
    val optionalUpdate: StateFlow<Boolean> = _optionalUpdate

    private val _storeUrl = MutableStateFlow<String?>(null)
    val storeUrl: StateFlow<String?> = _storeUrl

    fun checkForUpdate(configUrl: String) {
        viewModelScope.launch {
            try {
                val config = checkUseCase.fetchVersionConfig(configUrl)
                val current = getCurrentAppVersion()

                val forceResult = isVersionLess(current, config.forceUpdateOnOrBelow)
                val optionalResult = isVersionLess(current, config.latestVersion)

                if (forceResult) {
                    _forceUpdate.value = true
                    _storeUrl.value = pickStoreUrl(config)
                } else if (optionalResult) {
                    _optionalUpdate.value = true
                    _storeUrl.value = pickStoreUrl(config)
                }
            } catch (e: Exception) {
                println("VersionCheck FAILED: ${e.message}")
            }
        }
    }

    fun dismissOptionalUpdate() {
        _optionalUpdate.value = false
    }

    private fun pickStoreUrl(config: VersionConfig): String? =
        if (currentPlatform() == Platform.ANDROID)
            config.androidStoreUrl
        else
            config.iosStoreUrl
}