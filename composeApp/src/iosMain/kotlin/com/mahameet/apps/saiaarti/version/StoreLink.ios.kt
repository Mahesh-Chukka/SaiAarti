package com.mahameet.apps.saiaarti.version

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual fun openStoreLink(url: String) {
    UIApplication.sharedApplication.openURL(NSURL.URLWithString(url)!!)
}