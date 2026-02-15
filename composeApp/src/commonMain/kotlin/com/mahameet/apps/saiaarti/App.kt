package com.mahameet.apps.saiaarti

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mahameet.apps.saiaarti.navigation.NavGraph
import com.mahameet.apps.saiaarti.theme.AppTheme
import com.mahameet.apps.saiaarti.ui.components.AppBackground

@Composable
fun App() {
    AppTheme {
        AppBackground {
            NavGraph()
        }
    }
}
