package com.mahameet.apps.saiaarti.di

import com.mahameet.apps.saiaarti.pdf.PdfPathProvider
import org.koin.core.module.Module
import org.koin.dsl.module

fun platformModule(): Module = module {
    single { PdfPathProvider() }
}
