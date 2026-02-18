package com.mahameet.apps.saiaarti.version

import android.content.Context
import android.content.pm.PackageInfo

// Must be initialized once before using getCurrentAppVersion()
lateinit var androidAppContext: Context

actual fun getCurrentAppVersion(): String {
    val pm = androidAppContext.packageManager
    val info: PackageInfo = pm.getPackageInfo(androidAppContext.packageName, 0)
    return info.versionName ?: "0.0.0"
}