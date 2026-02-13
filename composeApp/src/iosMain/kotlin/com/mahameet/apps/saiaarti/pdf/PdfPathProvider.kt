package com.mahameet.apps.saiaarti.pdf

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.*

actual class PdfPathProvider {

    @OptIn(ExperimentalForeignApi::class)
    actual fun getPdfDirectoryPath(): String {
        val documentUrl = NSFileManager.defaultManager
            .URLsForDirectory(
                directory = NSDocumentDirectory,
                inDomains = NSUserDomainMask
            )
            .first() as NSURL

        val prayersUrl = documentUrl.URLByAppendingPathComponent("prayers")

        NSFileManager.defaultManager.createDirectoryAtURL(
            url = prayersUrl!!,
            withIntermediateDirectories = true,
            attributes = null,
            error = null
        )

        return prayersUrl.path!!
    }
}
