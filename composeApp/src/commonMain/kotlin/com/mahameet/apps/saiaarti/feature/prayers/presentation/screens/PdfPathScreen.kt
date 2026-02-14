package com.mahameet.apps.saiaarti.feature.prayers.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.Language
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.PrayerTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfPathScreen(
    language: Language,
    time: PrayerTime,
    path: String,
    isLoading: Boolean,
    error: String?,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("PDF") },
                navigationIcon = {
                    IconButton(onClick = onBack) { Text("←") }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Language: ${language.displayName}")
            Text("Time: ${time.displayName}")

            if (isLoading) {
                CircularProgressIndicator()
            }

            error?.let {
                Text(it, color = MaterialTheme.colorScheme.error)
            }

            Text(
                text = "Local file path:",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = path,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
