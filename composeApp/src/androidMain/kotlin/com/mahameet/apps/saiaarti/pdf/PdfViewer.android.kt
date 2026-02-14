package com.mahameet.apps.saiaarti.pdf

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import java.io.File
import kotlin.math.max
import kotlin.math.min

@Composable
actual fun PdfViewer(
    filePath: String,
    modifier: Modifier
) {
    val bitmaps by produceState<List<Bitmap>>(initialValue = emptyList(), key1 = filePath) {
        value = renderPdfToBitmaps(filePath)
    }

    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    val transformState = rememberTransformableState { zoomChange, panChange, _ ->
        scale = (scale * zoomChange).coerceIn(1f, 4f)
        offsetX += panChange.x
        offsetY += panChange.y
    }

    Box(modifier = modifier.fillMaxSize()) {
        // Zoomable content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .transformable(transformState)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offsetX
                    translationY = offsetY
                }
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(bitmaps) { _, bmp ->
                    Image(
                        bitmap = bmp.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
        }

        // Simple +/- buttons (nice on emulator and accessibility)
        Column(
            modifier = Modifier
                .align(androidx.compose.ui.Alignment.BottomEnd)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FloatingActionButton(onClick = { scale = min(4f, scale + 0.25f) }) { Text("+") }
            FloatingActionButton(onClick = { scale = max(1f, scale - 0.25f) }) { Text("-") }
            FloatingActionButton(onClick = { scale = 1f; offsetX = 0f; offsetY = 0f }) { Text("↺") }
        }
    }
}

private fun renderPdfToBitmaps(filePath: String): List<Bitmap> {
    val file = File(filePath)
    if (!file.exists()) return emptyList()

    val pfd = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
    val renderer = PdfRenderer(pfd)

    val list = mutableListOf<Bitmap>()
    try {
        for (i in 0 until renderer.pageCount) {
            val page = renderer.openPage(i)
            val bitmap = Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
            page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            page.close()
            list.add(bitmap)
        }
    } finally {
        renderer.close()
        pfd.close()
    }
    return list
}
