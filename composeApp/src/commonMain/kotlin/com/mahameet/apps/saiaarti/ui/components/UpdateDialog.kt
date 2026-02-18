package com.mahameet.apps.saiaarti.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.mahameet.apps.saiaarti.version.openStoreLink

@Composable
fun UpdateDialog(
    title: String,
    message: String,
    storeUrl: String?,
    showLater: Boolean,
    onLater: () -> Unit = {}
) {
    AlertDialog(
        onDismissRequest = {
            if (showLater) onLater()
        },
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            Button(
                onClick = { storeUrl?.let { openStoreLink(it) } }
            ) {
                Text("Update")
            }
        },
        dismissButton = {
            if (showLater) {
                TextButton(
                    onClick = { onLater() }
                ) {
                    Text("Later")
                }
            }
        }
    )
}