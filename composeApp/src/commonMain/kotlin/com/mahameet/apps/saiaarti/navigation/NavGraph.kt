package com.mahameet.apps.saiaarti.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahameet.apps.saiaarti.feature.prayers.PrayersScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SaiAarati,
    ) {
        composable(Routes.SaiAarati) {
            PrayersScreen()
        }
    }
}
