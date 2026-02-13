package com.mahameet.apps.saiaarti

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mahameet.apps.saiaarti.di.initKoin
import com.mahameet.apps.saiaarti.navigation.NavGraph
import com.mahameet.apps.saiaarti.theme.AppTheme

@Composable
fun App() {
    remember { initKoin(); Unit }
    AppTheme {
        NavGraph()
    }
}
