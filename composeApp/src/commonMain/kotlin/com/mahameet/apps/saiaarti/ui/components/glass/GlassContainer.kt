package com.mahameet.apps.saiaarti.ui.components.glass

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun GlassContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
)