package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MangaTranslateLanguageBS(
    onSetLanguageClick: (String) -> Unit,
    onDismissRequest: () -> Unit,
    availableLanguages: List<String>,
    selectedLanguage: String?
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        shape = mShapes.small,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ) {
        HorizontalDivider(modifier = Modifier.fillMaxWidth())

        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(availableLanguages) { language ->
                LanguageItem(
                    selectedLanguage = selectedLanguage,
                    onRadioClick = { onSetLanguageClick(language) },
                    language = language
                )
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
            style = mTypography.bodyLarge
        )

        RadioButton(
            selected = selectedLanguage == language,
            onClick = { onRadioClick(language) },
            modifier = Modifier.size(16.dp)
        )
    }
}