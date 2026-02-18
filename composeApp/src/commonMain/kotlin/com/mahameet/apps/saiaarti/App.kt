package com.mahameet.apps.saiaarti

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mahameet.apps.saiaarti.navigation.NavGraph
import com.mahameet.apps.saiaarti.theme.AppTheme
import com.mahameet.apps.saiaarti.ui.components.AppBackground
import com.mahameet.apps.saiaarti.ui.components.UpdateDialog
import com.mahameet.apps.saiaarti.version.VersionViewModel
import org.koin.compose.koinInject

private const val VERSION_CONFIG_URL =
    "https://raw.githubusercontent.com/Mahesh-Chukka/saiaarti-app-version-json/main/version.json"

@Composable
fun App() {

    AppTheme {
        AppBackground {
            val versionVm: VersionViewModel = koinInject()
            val forceUpdate by versionVm.forceUpdate.collectAsState()
            val optionalUpdate by versionVm.optionalUpdate.collectAsState()
            val storeUrl by versionVm.storeUrl.collectAsState()

            LaunchedEffect(Unit) {
                versionVm.checkForUpdate(
                    VERSION_CONFIG_URL
                )
            }

            if (optionalUpdate) {
                UpdateDialog(
                    title = "Update Available",
                    message = "A newer version of the app is available.",
                    storeUrl = storeUrl,
                    showLater = true,
                    onLater = { versionVm.dismissOptionalUpdate() }
                )
            }

            if (forceUpdate) {
                UpdateDialog(
                    title = "Update Required",
                    message = "Please update the app to continue.",
                    storeUrl = storeUrl,
                    showLater = false
                )
            }

            NavGraph()
        }
    }
}
