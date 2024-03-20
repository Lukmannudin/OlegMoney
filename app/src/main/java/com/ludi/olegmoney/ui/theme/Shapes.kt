package com.ludi.olegmoney.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(Dimens.spacingXS),
    medium = RoundedCornerShape(Dimens.spacing),
    large = RoundedCornerShape(Dimens.SpacingXL),
)

object Dimens {
    val spacingXXS = 8.dp
    val spacingXS = 12.dp
    val spacing = 16.dp
    val SpacingXL = 18.dp
    val spacingXXL = 24.dp
    val SpacingXXXL = 32.dp
    val SpacingXXXXL = 42.dp
}

@Immutable
data class ExtendedOlegShape(
    val small: RoundedCornerShape,
    val medium: RoundedCornerShape,
    val large: RoundedCornerShape
)

internal val extendedMatterShape = ExtendedOlegShape(
    small = RoundedCornerShape(Dimens.spacingXS),
    medium = RoundedCornerShape(Dimens.spacing),
    large = RoundedCornerShape(Dimens.SpacingXL)
)

internal val LocalOlegShapes = staticCompositionLocalOf<ExtendedOlegShape> {
//    /*If not used withing MatterTheme, an exception will be thrown*/
    error("OlegTheme not provided")
}

