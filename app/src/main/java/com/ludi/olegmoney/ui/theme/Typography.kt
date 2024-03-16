package com.ludi.olegmoney.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object TextSize {
    val titleX = 64.sp
    val title1 = 32.sp
    val title2 = 24.sp
    val title3 = 18.sp
    val regular1 = 16.sp
    val regular2 = 16.sp
    val regular3 = 14.sp
    val small = 13.sp
    val tiny = 12.sp
}

val titleX = TextStyle(
    fontSize = 64.sp,
    lineHeight = 80.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.Bold,
    color = olegColor.Dark75
)

val title1 = TextStyle(
    fontSize = 32.sp,
    lineHeight = 34.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.Bold,
    color = olegColor.Dark75
)

val title2 = TextStyle(
    fontSize = 24.sp,
    lineHeight = 22.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.SemiBold,
    color = olegColor.Dark75
)

val title3 = TextStyle(
    fontSize = 18.sp,
    lineHeight = 22.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.SemiBold,
    color = olegColor.Dark75
)

val regular1 = TextStyle(
    fontSize = 16.sp,
    lineHeight = 19.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.Normal,
    color = olegColor.Dark75
)

val regular2 = TextStyle(
    fontSize = 16.sp,
    lineHeight = 19.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.SemiBold,
    color = olegColor.Dark75
)

val regular3 = TextStyle(
    fontSize = 14.sp,
    lineHeight = 18.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.Normal
)

val small = TextStyle(
    fontSize = 13.sp,
    lineHeight = 16.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.Normal,
    color = olegColor.Dark75
)

val tiny = TextStyle(
    fontSize = 12.sp,
    lineHeight = 12.sp,
    fontFamily = FontInter,
    color = olegColor.Dark75,
    fontWeight = FontWeight.Normal
)

@Immutable
data class ReplacementTypography(
    val titleX: TextStyle,
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val regular1: TextStyle,
    val regular2: TextStyle,
    val regular3: TextStyle,
    val small: TextStyle,
    val tiny: TextStyle
)

internal val replacementTypography = ReplacementTypography(
    titleX = titleX,
    title1 = title1,
    title2 = title2,
    title3 = title3,
    regular1 = regular1,
    regular2 = regular2,
    regular3 = regular3,
    small = small,
    tiny = tiny
)

internal val LocalReplacementTypography = staticCompositionLocalOf {
    replacementTypography
}

val Typography = Typography(
    headlineMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Medium,
        fontSize = TextSize.titleX,
        color = olegColor.Dark50
    ),
    titleLarge = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Bold,
        fontSize = TextSize.title1,
        color = olegColor.Dark100,
    ),
    titleMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Bold,
        fontSize = TextSize.title2,
        color = olegColor.Dark100
    ),
    titleSmall = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Medium,
        fontSize = TextSize.title2,
        color = olegColor.Dark100
    ),
    bodyLarge = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.title3,
        color = olegColor.Dark100
    ),
    bodyMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.regular1,
        color = olegColor.Dark50
    ),
    bodySmall = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.regular2,
        color = olegColor.Dark25
    ),
)