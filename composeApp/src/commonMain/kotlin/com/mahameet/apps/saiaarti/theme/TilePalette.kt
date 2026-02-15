package com.mahameet.apps.saiaarti.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import kotlin.math.abs

data class TilePalette(
    val container: Color,
    val badge: Color
)

@Composable
fun tilePalette(seed: String): TilePalette {
    val scheme = MaterialTheme.colorScheme

    val hash = abs(seed.hashCode())

    // Generate hue between 0–360
    val hue = (hash % 360).toFloat()

    // Vibrant but not neon
    val saturation = 0.65f
    val lightness = if (scheme.background.luminance() > 0.5f) 0.75f else 0.35f

    val base = hslToColor(hue, saturation, lightness)

    val container = base.copy(alpha = 0.25f)
    val badge = base

    return TilePalette(container = container, badge = badge)
}

fun hslToColor(h: Float, s: Float, l: Float): Color {
    val c = (1 - kotlin.math.abs(2 * l - 1)) * s
    val x = c * (1 - kotlin.math.abs((h / 60) % 2 - 1))
    val m = l - c / 2

    val (r1, g1, b1) = when {
        h < 60 -> Triple(c, x, 0f)
        h < 120 -> Triple(x, c, 0f)
        h < 180 -> Triple(0f, c, x)
        h < 240 -> Triple(0f, x, c)
        h < 300 -> Triple(x, 0f, c)
        else -> Triple(c, 0f, x)
    }

    return Color(r1 + m, g1 + m, b1 + m)
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