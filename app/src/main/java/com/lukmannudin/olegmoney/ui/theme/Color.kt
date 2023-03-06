package com.lukmannudin.olegmoney.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

object OlegColor {
    val Violet = Color(0xFF7F3DFF)
    val LightViolet = Color(0xFFEEE5FF)
    val SpanishGray = Color(0xFF9F9F91)
}

val LightColorPalette = lightColorScheme(
    primary = OlegColor.Violet,
    primaryContainer = OlegColor.LightViolet,
    secondary = OlegColor.SpanishGray
)