package com.ludi.olegmoney.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle

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

private val replacementTypography = ReplacementTypography(
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

val LocalReplacementTypography = staticCompositionLocalOf {
    replacementTypography
}

@Immutable
data class OlegShapes(
    val component: Shape, val surface: Shape
)

val LocalOlegShapes = staticCompositionLocalOf {
    OlegShapes(
        component = RoundedCornerShape(ZeroCornerSize), surface = RoundedCornerShape(ZeroCornerSize)
    )
}

@Composable
fun OlegTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {


    val olegShapes = OlegShapes(
        component = Shapes.large, surface = Shapes.medium
    )

    CompositionLocalProvider(
        LocalReplacementTypography provides replacementTypography,
        LocalOlegShapes provides olegShapes
    ) {
        MaterialTheme(
            colorScheme = LightColorPalette,
            shapes = Shapes,
            typography = Typography,
            content = content
        )
    }
}

object OlegTheme {

    val typography: ReplacementTypography
        @Composable
        get() = LocalReplacementTypography.current

    val shapes: OlegShapes
        @Composable get() = LocalOlegShapes.current
}