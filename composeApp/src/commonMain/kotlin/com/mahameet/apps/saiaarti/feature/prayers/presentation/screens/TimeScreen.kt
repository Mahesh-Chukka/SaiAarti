package com.mahameet.apps.saiaarti.feature.prayers.presentation.screens

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
        topBar = {
            TopAppBar(
                title = { Text(language.nativeName) },
                navigationIcon = { IconButton(onClick = onBack) { Text("←") } }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(times) { time ->
                val palette = tilePalette("time_${language.code}_${time.id}")

                TileCard(
                    title = localizedTimeLabel(language, time),
                    subtitle = null,
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

private fun timeIcon(time: PrayerTime): ImageVector = when (time) {
    PrayerTime.MORNING -> Icons.Filled.WbSunny
    PrayerTime.AFTERNOON -> Icons.Filled.LightMode
    PrayerTime.EVENING -> Icons.Filled.WbTwilight
    PrayerTime.NIGHT -> Icons.Filled.DarkMode
}

fun localizedTimeLabel(lang: Language, time: PrayerTime): String = when (lang) {
    Language.TELUGU -> when (time) {
        PrayerTime.MORNING -> "ఉదయం"
        PrayerTime.AFTERNOON -> "మధ్యాహ్నం"
        PrayerTime.EVENING -> "సాయంత్రం"
        PrayerTime.NIGHT -> "రాత్రి"
    }
    Language.HINDI -> when (time) {
        PrayerTime.MORNING -> "सुबह"
        PrayerTime.AFTERNOON -> "दोपहर"
        PrayerTime.EVENING -> "शाम"
        PrayerTime.NIGHT -> "रात"
    }
    Language.ENGLISH -> when (time) {
        PrayerTime.MORNING -> "Morning"
        PrayerTime.AFTERNOON -> "Afternoon"
        PrayerTime.EVENING -> "Evening"
        PrayerTime.NIGHT -> "Night"
    }
    Language.TAMIL -> when (time) {
        PrayerTime.MORNING -> "காலை"
        PrayerTime.AFTERNOON -> "மதியம்"
        PrayerTime.EVENING -> "மாலை"
        PrayerTime.NIGHT -> "இரவு"
    }
    Language.MARATHI -> when (time) {
        PrayerTime.MORNING -> "सकाळ"
        PrayerTime.AFTERNOON -> "दुपार"
        PrayerTime.EVENING -> "संध्याकाळ"
        PrayerTime.NIGHT -> "रात्र"
    }
    Language.MALAYALAM -> when (time) {
        PrayerTime.MORNING -> "രാവിലെ"
        PrayerTime.AFTERNOON -> "ഉച്ച"
        PrayerTime.EVENING -> "വൈകുന്നേരം"
        PrayerTime.NIGHT -> "രാത്രി"
    }
    Language.BENGALI -> when (time) {
        PrayerTime.MORNING -> "সকাল"
        PrayerTime.AFTERNOON -> "দুপুর"
        PrayerTime.EVENING -> "সন্ধ্যা"
        PrayerTime.NIGHT -> "রাত"
    }
    else -> when(time) {
        PrayerTime.MORNING -> "সকাল"
        PrayerTime.AFTERNOON -> "দুপুর"
        PrayerTime.EVENING -> "সন্ধ্যা"
        PrayerTime.NIGHT -> "রাত"
    }
}

