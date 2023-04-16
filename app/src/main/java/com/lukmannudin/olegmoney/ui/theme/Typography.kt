package com.lukmannudin.olegmoney.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object TextSize {
    val title1 = 32.sp
    val title2 = 24.sp
    val title3 = 18.sp
    val regular1 = 16.sp
    val regular2 = 14.sp
    val small = 13.sp
    val tiny = 12.sp
}

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Bold,
        fontSize = TextSize.title1,
        color = Color.Black,
    ),
    titleMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Bold,
        fontSize = TextSize.title2,
        color = Color.Black
    ),
    titleSmall = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Medium,
        fontSize = TextSize.title2,
        color = Color.Black
    ),
    bodyLarge = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Bold,
        fontSize = TextSize.title3,
        color = Color.Black
    ),
    bodyMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.regular1,
        color = OlegColor.SpanishGray
    ),
    bodySmall = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.regular2,
        color = OlegColor.SpanishGray
    ),
)