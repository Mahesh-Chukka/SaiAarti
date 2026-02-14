package com.mahameet.apps.saiaarti.feature.prayers.data.datasource

import org.jetbrains.compose.resources.ExperimentalResourceApi
import saiaarti.composeapp.generated.resources.Res

class BundledPdfDataSource {

    private fun fileName(languageCode: String, prayerTimeId: String): String =
        "${languageCode}_${prayerTimeId}.pdf"

    @OptIn(ExperimentalResourceApi::class)
    suspend fun readPdfBytes(languageCode: String, prayerTimeId: String): ByteArray {
        val name = fileName(languageCode, prayerTimeId)
        return Res.readBytes("files/pdf/$name")
    }
}
