package com.mahameet.apps.saiaarti.version

import kotlinx.serialization.Serializable

@Serializable
data class VersionConfig(
    val latestVersion: String,
    val minSupportedVersion: String,
    val forceUpdateOnOrBelow: String,
    val androidStoreUrl: String? = null,
    val iosStoreUrl: String? = null,
)