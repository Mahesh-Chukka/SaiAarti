package com.mahameet.apps.saiaarti.feature.prayers.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.Language

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageScreen(
    languages: List<Language>,
    onSelect: (Language) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Select Language") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(languages) { lang ->
                ListItem(
                    headlineContent = { Text(lang.displayName) },
                    modifier = Modifier
                        .clickable { onSelect(lang) }
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )
                HorizontalDivider()
            }
        }
    }
}
