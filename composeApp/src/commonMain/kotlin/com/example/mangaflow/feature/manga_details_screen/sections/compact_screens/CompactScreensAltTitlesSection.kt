package com.example.mangaflow.feature.manga_details_screen.sections.compact_screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.custom_modifiers.noRippleClickable
import com.example.mangaflow.core.design_system.icons.MangaFlowIcons
import com.example.mangaflow.core.design_system.theme.mTypography
import org.jetbrains.compose.resources.painterResource
import com.example.mangaflow.core.data.network.models.manga_details_response.AltTitle as MangaDetailsResponseAltTitle

@Composable
fun CompactScreensAltTitlesSection(
    altTitles: List<MangaDetailsResponseAltTitle>
) {
    val filteredAltTitles = altTitles.flatMap { altTitle ->
        listOfNotNull(
            "ar" to altTitle.ar,
            "en" to altTitle.en,
            "fa" to altTitle.fa,
            "he" to altTitle.he,
            "id" to altTitle.id,
            "ja" to altTitle.ja,
            "ja-ro" to altTitle.jaRo,
            "ka" to altTitle.ka,
            "ko" to altTitle.ko,
            "ko-ro" to altTitle.koRo,
            "pt-br" to altTitle.ptBr,
            "ru" to altTitle.ru,
            "tr" to altTitle.tr,
            "uk" to altTitle.uk,
            "zh" to altTitle.zh,
            "zh-hk" to altTitle.zhHk
        ).filter { it.second != null }
    }

    var expanded by rememberSaveable { mutableStateOf(false) }
    val notExpandedAltTitles = filteredAltTitles.take(5)

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .animateContentSize()
    ) {
        if(!expanded) {
            notExpandedAltTitles.forEach { altTitle ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = altTitle.first.uppercase(),
                        style = mTypography.bodyLarge
                    )

                    Text(
                        text = altTitle.second.toString(),
                        style = mTypography.bodyLarge
                    )
                }
            }
        } else {
            filteredAltTitles.forEach { altTitle ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = altTitle.first.uppercase(),
                        style = mTypography.bodyLarge
                    )

                    Text(
                        text = altTitle.second.toString(),
                        style = mTypography.bodyLarge
                    )
                }
            }
        }

        val scaleY by animateFloatAsState(
            targetValue = if(expanded) 1f else -1f,
            label = "Animation for icon"
        )
        Icon(
            painter = painterResource(MangaFlowIcons.ArrowUpFilled),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .graphicsLayer(scaleY = scaleY)
                .noRippleClickable {
                    expanded = !expanded
                }
        )
    }
}