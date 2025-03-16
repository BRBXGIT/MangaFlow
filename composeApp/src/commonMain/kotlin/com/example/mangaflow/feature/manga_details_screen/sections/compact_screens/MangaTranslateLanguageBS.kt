package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MangaTranslateLanguageBS(
    onGetMangaClick: () -> Unit,
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

        var languageNotSelectedError by rememberSaveable { mutableStateOf(false) }
        AnimatedVisibility(
            visible = languageNotSelectedError,
            enter = fadeIn(tween(300)) + expandVertically(tween(300)),
            exit = fadeOut(tween(300)) + shrinkVertically(tween(300))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = mColors.errorContainer,
                        shape = RoundedCornerShape(
                            bottomEnd = 4.dp,
                            bottomStart = 4.dp
                        )
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = "Please select language",
                    style = mTypography.labelMedium
                )
            }
        }

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

            item {
                LaunchedEffect(languageNotSelectedError) {
                    if(languageNotSelectedError) {
                        delay(3000)
                        languageNotSelectedError = false
                    }
                }

                Button(
                    shape = mShapes.small,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        if(selectedLanguage != null) {
                            onGetMangaClick()
                        } else {
                            languageNotSelectedError = true
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