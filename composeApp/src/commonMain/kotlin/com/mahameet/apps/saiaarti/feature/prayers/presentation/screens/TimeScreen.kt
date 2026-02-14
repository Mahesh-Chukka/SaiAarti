package com.mahameet.apps.saiaarti.feature.prayers.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.Language
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.PrayerTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(
    language: Language,
    times: List<PrayerTime>,
    onSelect: (PrayerTime) -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Select Time") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Text("←")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = "Language: ${language.displayName}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp)
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(times) { time ->
                    ListItem(
                        headlineContent = { Text(time.displayName) },
                        modifier = Modifier
                            .clickable { onSelect(time) }
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}
