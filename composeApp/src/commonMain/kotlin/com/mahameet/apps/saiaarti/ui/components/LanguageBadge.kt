package com.mahameet.apps.saiaarti.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.contentColorFor

@Composable
fun LanguageBadge(
    text: String,
    bg: Color,
    modifier: Modifier = Modifier
) {
    val textColor = contentColorFor(bg)

    Box(
        modifier = modifier
            .size(48.dp)
            .background(bg, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.titleMedium
        )
    }
}