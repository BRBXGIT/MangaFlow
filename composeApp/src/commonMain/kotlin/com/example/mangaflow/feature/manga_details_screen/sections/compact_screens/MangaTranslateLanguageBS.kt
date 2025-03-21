package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.feature.manga_details_screen.sections.common.SelectTranslationLanguageLCSection

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

        SelectTranslationLanguageLCSection(
            onSetLanguageClick = {
                onSetLanguageClick(it)
                onDismissRequest()
            },
            availableLanguages = availableLanguages,
            selectedLanguage = selectedLanguage
        )
    }
}