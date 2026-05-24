package com.mahameet.apps.saiaarti.feature.info.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mahameet.apps.saiaarti.version.openStoreLink

private const val SUPPORT_EMAIL = "mailto:support@mahameetllc.com"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Support") },
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "We're happy to help with any questions or feedback.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Button(
                onClick = { openStoreLink(SUPPORT_EMAIL) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.Email, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Email Us")
            }

            Text(
                "support@mahameetllc.com  ·  Response within 1–2 business days",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            HorizontalDivider()

            Text("Frequently Asked Questions", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)

            FaqItem(
                q = "How do I change the language?",
                a = "Tap the back arrow from any screen to return to the language selection screen."
            )
            FaqItem(
                q = "The PDF is not loading. What should I do?",
                a = "Close and reopen the app. If the problem continues, email us with your device model and OS version."
            )
            FaqItem(
                q = "Is the app free?",
                a = "Yes - completely free with no in-app purchases, subscriptions, or ads."
            )
            FaqItem(
                q = "Does the app need internet?",
                a = "No. All prayer content works offline. Internet is used only to check for app updates."
            )
            FaqItem(
                q = "Do I need to create an account?",
                a = "No account or login is needed."
            )

            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun FaqItem(q: String, a: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(q, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
        Text(a, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
