package com.mahameet.apps.saiaarti.feature.prayers.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.WbTwilight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.vector.ImageVector
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.Language
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.PrayerTime
import com.mahameet.apps.saiaarti.theme.tilePalette
import com.mahameet.apps.saiaarti.ui.components.TileCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(
    language: Language,
    times: List<PrayerTime>,
    onSelect: (PrayerTime) -> Unit,
    onBack: () -> Unit
) {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text(language.nativeName) },
                navigationIcon = { IconButton(onClick = onBack) { Text("←") } }
            )
        }
    ) { padding ->
        Box(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(times) { time ->
                    val palette = tilePalette("time_${language.code}_${time.id}")
                    val title = language.timeLabel(time)
                    val subtitle = language.ritualLabel(time)
                    TileCard(
                        title = title,
                        subtitle = subtitle,
                        leading = {
                            Icon(
                                imageVector = timeIcon(time),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp),
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        },
                        containerColor = palette.container,
                        onClick = { onSelect(time) }
                    )
                }
            }
        }
    }
}

private fun timeIcon(time: PrayerTime): ImageVector = when (time) {
    PrayerTime.MORNING -> Icons.Filled.WbSunny
    PrayerTime.AFTERNOON -> Icons.Filled.LightMode
    PrayerTime.EVENING -> Icons.Filled.WbTwilight
    PrayerTime.NIGHT -> Icons.Filled.DarkMode
}

