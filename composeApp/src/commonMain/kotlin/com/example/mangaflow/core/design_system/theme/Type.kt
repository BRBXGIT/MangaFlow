package com.example.mangaflow.core.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import mangaflow.composeapp.generated.resources.Res
import mangaflow.composeapp.generated.resources.roboto_regular
import mangaflow.composeapp.generated.resources.roboto_thinitalic
import mangaflow.composeapp.generated.resources.roboto_black
import mangaflow.composeapp.generated.resources.roboto_blackitalic
import mangaflow.composeapp.generated.resources.roboto_bold
import mangaflow.composeapp.generated.resources.roboto_bolditalic
import mangaflow.composeapp.generated.resources.roboto_italic
import mangaflow.composeapp.generated.resources.roboto_light
import mangaflow.composeapp.generated.resources.roboto_lightitalic
import mangaflow.composeapp.generated.resources.roboto_medium
import mangaflow.composeapp.generated.resources.roboto_mediumitalic
import mangaflow.composeapp.generated.resources.roboto_thin
import org.jetbrains.compose.resources.Font

@Composable
fun Typography(): Typography {
    val fontFamily = FontFamily(
        Font(Res.font.roboto_regular),
        Font(Res.font.roboto_bold),
        Font(Res.font.roboto_black),
        Font(Res.font.roboto_blackitalic),
        Font(Res.font.roboto_bolditalic),
        Font(Res.font.roboto_italic),
        Font(Res.font.roboto_light),
        Font(Res.font.roboto_lightitalic),
        Font(Res.font.roboto_medium),
        Font(Res.font.roboto_mediumitalic),
        Font(Res.font.roboto_thin),
        Font(Res.font.roboto_thinitalic)
    )

    val typography = Typography(
        displayLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 57.sp,
            lineHeight = 64.sp,
            letterSpacing = (-0.25).sp,
            fontFamily = fontFamily
        ),
        displayMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 45.sp,
            lineHeight = 52.sp,
            letterSpacing = 0.sp,
            fontFamily = fontFamily
        ),
        displaySmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 36.sp,
            lineHeight = 44.sp,
            letterSpacing = 0.sp,
            fontFamily = fontFamily
        ),
        headlineLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.sp,
            fontFamily = fontFamily
        ),
        headlineMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 28.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp,
            fontFamily = fontFamily
        ),
        headlineSmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.sp,
            fontFamily = fontFamily
        ),
        titleLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp,
            fontFamily = fontFamily
        ),
        titleMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.1.sp,
            fontFamily = fontFamily
        ),
        titleSmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
            fontFamily = fontFamily
        ),
        bodyLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
            fontFamily = fontFamily
        ),
        bodyMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            fontFamily = fontFamily
        ),
        bodySmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.4.sp,
            fontFamily = fontFamily
        ),
        labelLarge = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
            fontFamily = fontFamily
        ),
        labelMedium = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp,
            fontFamily = fontFamily
        ),
        labelSmall = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp,
            fontFamily = fontFamily
        )
    )

    return typography
}