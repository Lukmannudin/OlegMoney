package com.lukmannudin.olegmoney.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object TextSize {
    val titleLarge = 32.sp
    val titleMedium = 24.sp
    val bodyLarge = 18.sp
    val bodyMedium = 16.sp
}

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Bold,
        fontSize = TextSize.titleLarge,
        color = Color.Black,
    ),
    titleMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Bold,
        fontSize = TextSize.titleMedium,
        color = Color.Black
    ),
    // same as bodyMedium
    bodyLarge = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.bodyMedium,
        color = OlegColor.SpanishGray
    ),
    bodyMedium = TextStyle(
        fontFamily = FontInter,
        fontWeight = FontWeight.Normal,
        fontSize = TextSize.bodyMedium,
        color = OlegColor.SpanishGray
    )
)