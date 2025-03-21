package com.example.mangaflow.feature.manga_details_screen.sections.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.theme.mTypography
import com.example.mangaflow.feature.manga_details_screen.screen.common.TranslateGroup

@Composable
fun SelectTranslationGroupLCSection(
    availableGroups: List<TranslateGroup>,
    onSetGroupClick: (TranslateGroup) -> Unit,
    selectedGroup: TranslateGroup?
) {
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