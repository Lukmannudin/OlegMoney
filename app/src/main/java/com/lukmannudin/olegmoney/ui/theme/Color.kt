package com.lukmannudin.olegmoney.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

object OlegColor {
    // dark
    val Dark25 = Color(0xFF7A7E80)
    val Dark50 = Color(0xFF464A4D)
    val Dark75 = Color(0xFF161719)
    val Dark100 = Color(0xFF0A0A0A)

    // light
    val Light20 = Color(0xFFE3E5E5)
    val Light40 = Color(0xFFF2F4F5)
    val Light60 = Color(0xFFF7F9FA)
    val Light80 = Color(0xFFFBFBFB)
    val Light100 = Color(0xFFD9D9D9)

    // violet
    val Violet20 = Color(0xFFEEE5FF)
    val Violet40 = Color(0xFFD3BDFF)
    val Violet60 = Color(0xFFB18AFF)
    val Violet80 = Color(0xFF8F57FF)
    val Violet100 = Color(0xFF7F3DFF)

    val Violet = Color(0xFF7F3DFF)
    val LightViolet = Color(0xFFEEE5FF)
    val SpanishGray = Color(0xFF9F9F91)
    val FloralWhite = Color(0xFFF1F1FA)
    val Manatee = Color(0xFF91919F)
}

val LightColorPalette = lightColorScheme(
    primary = OlegColor.Violet100,
    primaryContainer = OlegColor.Violet60,
    secondary = OlegColor.Dark25
)