package com.mahameet.apps.saiaarti.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.material3.MaterialTheme

@Composable
fun AppBackground(content: @Composable () -> Unit) {
    val c = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        c.background,
                        c.surfaceVariant.copy(alpha = 0.6f),
                        c.background
                    )
                )
            )
    ) { content() }
}
