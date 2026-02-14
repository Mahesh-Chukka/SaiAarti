package com.mahameet.apps.saiaarti

import androidx.compose.ui.window.ComposeUIViewController
import com.mahameet.apps.saiaarti.di.initKoin
import com.mahameet.apps.saiaarti.di.platformModule

fun MainViewController() = ComposeUIViewController {
    initKoin(platformModules = listOf(platformModule()))
    App()
}