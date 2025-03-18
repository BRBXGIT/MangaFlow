package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import com.example.mangaflow.feature.manga_details_screen.screen.common.TranslateGroup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MangaTranslateGroupBS(
    onSetGroupClick: (TranslateGroup) -> Unit,
    onDismissRequest: () -> Unit,
    availableGroups: List<TranslateGroup>,
    selectedGroup: TranslateGroup?
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
            if(availableGroups.isNotEmpty()) {
                items(availableGroups) { group ->
                    GroupItem(
                        selectedGroup = selectedGroup,
                        onRadioClick = {
                            onSetGroupClick(
                                TranslateGroup(
                                    name = group.name,
                                    id = group.id
                                )
                            )
                        },
                        group = group
                    )
                }
            } else {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No groups found :("
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun GroupItem(
    selectedGroup: TranslateGroup?,
    onRadioClick: () -> Unit,
    group: TranslateGroup
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = group.name,
            style = mTypography.bodyLarge
        )

        RadioButton(
            selected = selectedGroup?.id == group.id,
            onClick = { onRadioClick() },
            modifier = Modifier.size(16.dp)
        )
    }
}