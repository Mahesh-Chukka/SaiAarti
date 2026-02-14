package com.mahameet.apps.saiaarti.pdf

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun PdfViewer(
    filePath: String,
    modifier: Modifier = Modifier
)
