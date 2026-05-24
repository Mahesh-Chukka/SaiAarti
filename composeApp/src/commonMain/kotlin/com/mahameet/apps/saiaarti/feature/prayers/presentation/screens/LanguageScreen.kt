@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.mahameet.apps.saiaarti.feature.prayers.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahameet.apps.saiaarti.feature.prayers.domain.model.Language
import com.mahameet.apps.saiaarti.theme.tilePalette
import com.mahameet.apps.saiaarti.ui.components.LanguageBadge
import com.mahameet.apps.saiaarti.ui.components.TileCard
import com.mahameet.apps.saiaarti.ui.components.glass.GlassContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageScreen(
    languages: List<Language>,
    onSelect: (Language) -> Unit,
    onInfoClick: () -> Unit = {}
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Select Language") },
                actions = {
                    IconButton(onClick = onInfoClick) {
                        Icon(Icons.Filled.Menu, contentDescription = "About")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(languages) { lang ->
                val palette = tilePalette("lang_${lang.code}")
                GlassContainer(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TileCard(
                        title = lang.nativeName,
                        subtitle = lang.englishName.takeIf { it != lang.nativeName },
                        leading = { LanguageBadge(text = lang.badge, bg = palette.badge) },
                        containerColor = palette.container,
                        onClick = { onSelect(lang) }
                    )
                }
            }
        }
    }
}
