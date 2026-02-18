package com.mahameet.apps.saiaarti.version

import platform.Foundation.NSBundle

actual fun getCurrentAppVersion(): String =
    NSBundle.mainBundle.infoDictionary?.get("CFBundleShortVersionString") as? String ?: "0.0.0"
