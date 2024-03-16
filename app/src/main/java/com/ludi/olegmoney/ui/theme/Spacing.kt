package com.ludi.olegmoney.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class OlegSpacing(
    val spacing0: Dp,
    val spacing1: Dp,
    val spacing2: Dp,
    val spacing3: Dp,
    val spacing4: Dp,
    val spacing5: Dp,
    val spacing6: Dp,
    val spacing7: Dp,
    val spacing8: Dp,
    val spacing9: Dp,
    val spacing10: Dp,
    val spacing11: Dp,
    val spacing12: Dp
)

val LocalOlegSpacing = staticCompositionLocalOf<OlegSpacing> {
    /*If not used withing MatterTheme, an exception will be thrown*/
    error("MatterTheme not provided")
}

val olegSpacing = OlegSpacing(
    spacing0 = 0.dp,
    spacing1 = 2.dp,
    spacing2 = 4.dp,
    spacing3 = 8.dp,
    spacing4 = 12.dp,
    spacing5 = 16.dp,
    spacing6 = 20.dp,
    spacing7 = 24.dp,
    spacing8 = 32.dp,
    spacing9 = 40.dp,
    spacing10 = 48.dp,
    spacing11 = 64.dp,
    spacing12 = 80.dp
)