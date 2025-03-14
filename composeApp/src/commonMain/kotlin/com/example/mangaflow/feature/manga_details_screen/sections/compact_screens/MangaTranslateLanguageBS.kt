package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MangaTranslateLanguageBS(
    onGetMangaClick: (String) -> Unit,
    onDismissRequest: () -> Unit,
    availableLanguages: List<String>
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        shape = mShapes.small
    ) {
        HorizontalDivider(modifier = Modifier.fillMaxWidth())

        var selectedLanguage by rememberSaveable { mutableStateOf<String?>(null) }
        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp)
        ) {
            items(availableLanguages) { language ->
                LanguageItem(
                    selectedLanguage = selectedLanguage,
                    onRadioClick = { selectedLanguage = language },
                    language = language
                )
            }

            item {
                Button(
                    shape = mShapes.small,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        if(selectedLanguage != null) {
                            onGetMangaClick(selectedLanguage!!)
                        }
                    }
                ) {
                    Text(
                        text = "Select language",
                        style = mTypography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
private fun LanguageItem(
    selectedLanguage: String?,
    onRadioClick: (String) -> Unit,
    language: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = language.uppercase(),
            style = mTypography.bodySmall
        )

        RadioButton(
            selected = selectedLanguage == language,
            onClick = { onRadioClick(language) },
            modifier = Modifier.size(16.dp)
        )
    }
}