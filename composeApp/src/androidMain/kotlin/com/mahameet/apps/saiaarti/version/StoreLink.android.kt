package com.mahameet.apps.saiaarti.version

import android.content.Intent
import android.net.Uri

actual fun openStoreLink(url: String) {
    // Use the global app context (not LocalContext.current)
    val context = androidAppContext
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    // This flag is safe on Android to start a new task
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}