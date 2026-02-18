package com.mahameet.apps.saiaarti.di

import com.mahameet.apps.saiaarti.feature.prayers.data.datasource.BundledPdfDataSource
import com.mahameet.apps.saiaarti.feature.prayers.data.repository.PrayerRepositoryImpl
import com.mahameet.apps.saiaarti.feature.prayers.domain.repository.PrayerRepository
import com.mahameet.apps.saiaarti.feature.prayers.presentation.PrayersViewModel
import com.mahameet.apps.saiaarti.version.VersionCheckUseCase
import com.mahameet.apps.saiaarti.version.VersionViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

private val commonModule = module {
    single { BundledPdfDataSource() }
    single<PrayerRepository> { PrayerRepositoryImpl(get(), get()) }
    factory { PrayersViewModel(get()) }
    single { VersionCheckUseCase() }
    factory { VersionViewModel(get()) }
}

/**
 * Platform modules must provide:
 * - PdfPathProvider
 * (Android needs Context, iOS doesn't)
 */
fun initKoin(platformModules: List<Module> = emptyList()) {
    startKoin {
        modules(commonModule + platformModules)
    }
}




