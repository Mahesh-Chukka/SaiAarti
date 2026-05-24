package com.mahameet.apps.saiaarti.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahameet.apps.saiaarti.feature.info.presentation.InfoScreen
import com.mahameet.apps.saiaarti.feature.info.presentation.PrivacyPolicyScreen
import com.mahameet.apps.saiaarti.feature.info.presentation.SupportScreen
import com.mahameet.apps.saiaarti.feature.prayers.presentation.PrayersScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SaiAarati,
    ) {
        composable(Routes.SaiAarati) {
            PrayersScreen(onInfoClick = { navController.navigate(Routes.Info) })
        }
        composable(Routes.Info) {
            InfoScreen(
                onBack = { navController.popBackStack() },
                onPrivacyClick = { navController.navigate(Routes.Privacy) },
                onSupportClick = { navController.navigate(Routes.Support) }
            )
        }
        composable(Routes.Privacy) {
            PrivacyPolicyScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.Support) {
            SupportScreen(onBack = { navController.popBackStack() })
        }
    }
}
