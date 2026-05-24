package com.mahameet.apps.saiaarti.feature.info.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy Policy") },
                navigationIcon = { IconButton(onClick = onBack) { Text("←") } }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                "Last updated: May 2026",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            PolicySection(
                title = "No Data Collected",
                body = "Sai Aarti does not collect, store, transmit, or share any personal information. " +
                        "This includes names, email addresses, device identifiers, location, and usage analytics."
            )

            PolicySection(
                title = "No Account or Login Required",
                body = "The app requires no account creation or sign-in. All features are fully available " +
                        "immediately after installation with no registration."
            )

            PolicySection(
                title = "No Advertising",
                body = "Sai Aarti contains no advertisements and integrates no advertising SDKs or " +
                        "third-party tracking frameworks."
            )

            PolicySection(
                title = "On-Device Content",
                body = "All prayer content (PDF files) is bundled with the app and stored locally on your " +
                        "device. No content is downloaded from external servers during normal use."
            )

            PolicySection(
                title = "Internet Access",
                body = "The app requests internet permission only to check whether a newer version is " +
                        "available on the App Store or Google Play. No personal data is sent in this request."
            )

            PolicySection(
                title = "Children's Privacy",
                body = "Because no data is collected from any user, the app is safe for all ages, " +
                        "including children under 13."
            )

            PolicySection(
                title = "Contact",
                body = "Questions about this policy? Email support@mahameetllc.com"
            )

            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun PolicySection(title: String, body: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
        Text(body, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
    }
}
