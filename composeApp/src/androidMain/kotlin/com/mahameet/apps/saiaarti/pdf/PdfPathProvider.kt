package com.mahameet.apps.saiaarti.pdf

import android.content.Context
import java.io.File

actual class PdfPathProvider(
    private val context: Context
) {

    actual fun getPdfDirectoryPath(): String {
        val dir = File(context.filesDir, "prayers")

        if (!dir.exists()) {
            dir.mkdirs()
        }

        return dir.absolutePath
    }
}
