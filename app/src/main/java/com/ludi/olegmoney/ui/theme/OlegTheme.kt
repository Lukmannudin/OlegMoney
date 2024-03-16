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
        LocalOlegShapes provides olegShapes,
        LocalOlegSpacing provides olegSpacing,
        LocalReplacementColor provides olegColor
    ) {
        MaterialTheme(
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

    val spacing: OlegSpacing
        @Composable get() = LocalOlegSpacing.current

    val color: OlegColor
        @Composable get() = LocalReplacementColor.current
}