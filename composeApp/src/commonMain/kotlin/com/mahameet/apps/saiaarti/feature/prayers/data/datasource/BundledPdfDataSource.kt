package com.mahameet.apps.saiaarti.feature.prayers.data.datasource

import org.jetbrains.compose.resources.ExperimentalResourceApi
import saiaarti.composeapp.generated.resources.Res.readBytes

class BundledPdfDataSource {

    fun fileName(languageCode: String, prayerTimeId: String): String {
        return "${languageCode}_${prayerTimeId}.pdf"
    }

    @OptIn(ExperimentalResourceApi::class)
    suspend fun readPdfBytes(languageCode: String, prayerTimeId: String): ByteArray {
        val name = fileName(languageCode, prayerTimeId)
        // This path is relative to composeResources/files/
        val resourcePath = "pdf/$name"
        return readBytes(resourcePath)
    }
}
