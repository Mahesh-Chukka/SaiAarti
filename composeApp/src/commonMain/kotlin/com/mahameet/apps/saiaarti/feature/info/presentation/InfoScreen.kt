package com.mahameet.apps.saiaarti.feature.info.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactSupport
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(
    onBack: () -> Unit,
    onPrivacyClick: () -> Unit,
    onSupportClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About") },
                navigationIcon = {
                    IconButton(onClick = onBack) { Text("←") }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Sai Aarti", style = MaterialTheme.typography.headlineSmall)
            Text(
                "A free devotional app. No ads, no login, and no data collected.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            OutlinedButton(
                onClick = onPrivacyClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.PrivacyTip, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Privacy Policy")
            }

            OutlinedButton(
                onClick = onSupportClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.ContactSupport, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Support & Help")
            }
        }
    }
}
