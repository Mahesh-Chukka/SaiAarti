package com.mahameet.apps.saiaarti.di

import android.content.Context
import com.mahameet.apps.saiaarti.pdf.PdfPathProvider
import org.koin.core.module.Module
import org.koin.dsl.module

fun platformModule(context: Context): Module = module {
    single { PdfPathProvider(context) }
}
