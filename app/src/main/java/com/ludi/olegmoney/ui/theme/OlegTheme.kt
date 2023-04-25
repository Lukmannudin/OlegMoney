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
data class OlegTypography(
    val body: TextStyle,
    val title: TextStyle
)

@Immutable
data class OlegShapes(
    val component: Shape,
    val surface: Shape
)

val LocalOlegTypography = staticCompositionLocalOf {
    OlegTypography(
        body = TextStyle.Default,
        title = TextStyle.Default
    )
}

val LocalOlegShapes = staticCompositionLocalOf {
    OlegShapes(
        component = RoundedCornerShape(ZeroCornerSize),
        surface = RoundedCornerShape(ZeroCornerSize)
    )
}

@Composable
fun OlegTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val olegTypography = OlegTypography(
        body = Typography.bodyMedium,
        title = Typography.titleMedium
    )

    val olegShapes = OlegShapes(
        component = Shapes.large,
        surface = Shapes.medium
    )

    CompositionLocalProvider(
        LocalOlegTypography provides olegTypography,
        LocalOlegShapes provides olegShapes
    ) {
        MaterialTheme(
            colorScheme = LightColorPalette,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object OlegTheme {
    val typography: OlegTypography
        @Composable
        get() = LocalOlegTypography.current

    val shapes: OlegShapes
        @Composable
        get() = LocalOlegShapes.current
}