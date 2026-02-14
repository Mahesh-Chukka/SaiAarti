package com.mahameet.apps.saiaarti.feature.prayers.data.repository

import com.mahameet.apps.saiaarti.feature.prayers.data.datasource.BundledPdfDataSource
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.Language
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.PrayerTime
import com.mahameet.apps.saiaarti.feature.prayers.domain.repository.PrayerRepository
import com.mahameet.apps.saiaarti.pdf.PdfPathProvider
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import okio.buffer
import okio.use

class PrayerRepositoryImpl(
    private val pdfPathProvider: PdfPathProvider,
    private val bundledPdfDataSource: BundledPdfDataSource
) : PrayerRepository {

    override fun getAvailableLanguages(): List<Language> = Language.entries

    override fun getPrayerTimes(language: Language): List<PrayerTime> = PrayerTime.entries

    override suspend fun getLocalPdfPath(language: Language, prayerTime: PrayerTime): String {
        val directory = pdfPathProvider.getPdfDirectoryPath()
        val fileName = "${language.code}_${prayerTime.id}.pdf"
        val targetPathString = "$directory/$fileName"
        val targetPath = targetPathString.toPath()

        // Copy once
        if (!FileSystem.SYSTEM.exists(targetPath)) {
            val bytes = bundledPdfDataSource.readPdfBytes(language.code, prayerTime.id)
            FileSystem.SYSTEM.sink(targetPath).buffer().use { sink ->
                sink.write(bytes)
            }
        }

        return targetPathString
    }
}
