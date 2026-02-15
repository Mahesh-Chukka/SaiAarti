package com.mahameet.apps.saiaarti.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import kotlin.math.abs

data class TilePalette(
    val container: Color,
    val badge: Color
)

@Composable
fun tilePalette(seed: String): TilePalette {
    val scheme = MaterialTheme.colorScheme
    val base = FestivalSeeds[abs(seed.hashCode()) % FestivalSeeds.size]

    // Blend with surfaces so it works in light/dark
    val container = lerp(scheme.surface, base, 0.55f)
    val badge = lerp(scheme.primary, base, 0.35f)

    return TilePalette(container = container, badge = badge)
}


private val FestivalSeeds = listOf(
    Color(0xFFFFC6A8), // peach
    Color(0xFFFFD6E7), // rose
    Color(0xFFFFE8A3), // marigold
    Color(0xFFC7F0BD), // tulsi green
    Color(0xFFBDE7FF), // sky
    Color(0xFFD8C7FF), // lavender
    Color(0xFFFFB7B7), // vermilion soft
    Color(0xFFFFF0B8), // sandal
)