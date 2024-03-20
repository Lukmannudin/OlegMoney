package com.ludi.olegmoney.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import javax.annotation.concurrent.Immutable


@Immutable
data class OlegColor(
    val dark25: Color,
    val dark50: Color,
    val Dark75: Color,
    val Dark100: Color,
    val Light20: Color,
    val Light40: Color,
    val Light60: Color,
    val Light80: Color,
    val Light100: Color,
    val Violet20: Color,
    val Violet40: Color,
    val Violet60: Color,
    val Violet80: Color,
    val Violet100: Color
)

internal val olegColor = OlegColor(
    dark25 = Color(0xFF7A7E80),
    dark50 = Color(0xFF464A4D),
    Dark75 = Color(0xFF161719),
    Dark100 = Color(0xFF0A0A0A),
    Light20 = Color(0xFF91919F),
    Light40 = Color(0xFFF2F4F5),
    Light60 = Color(0xFFF7F9FA),
    Light80 = Color(0xFFFBFBFB),
    Light100 = Color(0xFFD9D9D9),
    Violet20 = Color(0xFFEEE5FF),
    Violet40 = Color(0xFFD3BDFF),
    Violet60 = Color(0xFFB18AFF),
    Violet80 = Color(0xFF8F57FF),
    Violet100 = Color(0xFF7F3DFF)
)

internal val LocalReplacementColor = staticCompositionLocalOf {
    olegColor
}