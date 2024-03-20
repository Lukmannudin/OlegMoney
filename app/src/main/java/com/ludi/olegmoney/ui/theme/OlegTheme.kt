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


@Composable
fun OlegTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalReplacementTypography provides replacementTypography,
        LocalOlegShapes provides extendedMatterShape,
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

    val shapes: ExtendedOlegShape
        @Composable get() = LocalOlegShapes.current

    val spacing: OlegSpacing
        @Composable get() = LocalOlegSpacing.current

    val color: OlegColor
        @Composable get() = LocalReplacementColor.current
}