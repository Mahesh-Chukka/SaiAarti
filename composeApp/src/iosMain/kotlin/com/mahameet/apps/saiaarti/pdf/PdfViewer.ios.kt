package com.mahameet.apps.saiaarti.pdf

import kotlinx.cinterop.ExperimentalForeignApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import platform.CoreGraphics.CGRectMake
import platform.Foundation.NSURL
import platform.PDFKit.PDFDocument
import platform.PDFKit.PDFView
import platform.UIKit.UIView

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun PdfViewer(
    filePath: String,
    modifier: Modifier
) {
    UIKitView(
        modifier = modifier,
        factory = {
            val pdfView = PDFView(frame = CGRectMake(0.0, 0.0, 0.0, 0.0))
            pdfView.autoScales = true

            val url = NSURL.fileURLWithPath(filePath)
            pdfView.document = PDFDocument(url)

            pdfView as UIView
        },
        update = { view ->
            val pdfView = view as PDFView
            val url = NSURL.fileURLWithPath(filePath)
            pdfView.document = PDFDocument(url)
        }
    )
}
