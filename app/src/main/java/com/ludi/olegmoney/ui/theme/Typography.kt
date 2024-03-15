package com.ludi.olegmoney.ui.theme

import androidx.compose.material3.Typography
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
    color = OlegColor.Dark75
)

val title1 = TextStyle(
    fontSize = 32.sp,
    lineHeight = 34.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.Bold,
    color = OlegColor.Dark75
)

val title2 = TextStyle(
    fontSize = 24.sp,
    lineHeight = 22.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.SemiBold,
    color = OlegColor.Dark75
)

val title3 = TextStyle(
    fontSize = 18.sp,
    lineHeight = 22.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.SemiBold,
    color = OlegColor.Dark75
)

val regular1 = TextStyle(
    fontSize = 16.sp,
    lineHeight = 19.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.Normal,
    color = OlegColor.Dark75
)

val regular2 = TextStyle(
    fontSize = 16.sp,
    lineHeight = 19.sp,
    fontFamily = FontInter,
    fontWeight = FontWeight.SemiBold,
    color = OlegColor.Dark75
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
    color = OlegColor.Dark75
)

val tiny = TextStyle(
    fontSize = 12.sp,
    lineHeight = 12.sp,
    fontFamily = FontInter,
    color = OlegColor.Dark75,
    fontWeight = FontWeight.Normal
)

val Typography = Typography(
    headlineMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Medium,
        fontSize = TextSize.titleX,
        color = OlegColor.Dark50
    ),
    titleLarge = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Bold,
        fontSize = TextSize.title1,
        color = OlegColor.Dark100,
    ),
    titleMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Bold,
        fontSize = TextSize.title2,
        color = OlegColor.Dark100
    ),
    titleSmall = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Medium,
        fontSize = TextSize.title2,
        color = OlegColor.Dark100
    ),
    bodyLarge = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.title3,
        color = OlegColor.Dark100
    ),
    bodyMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.regular1,
        color = OlegColor.Dark50
    ),
    bodySmall = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.regular2,
        color = OlegColor.SpanishGray
    ),
)