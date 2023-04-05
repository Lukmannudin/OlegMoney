package com.lukmannudin.olegmoney.ui.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

fun String.parseFont(spanStyle: SpanStyle): AnnotatedString {
    val parts = this.split("`-`", "`-`")
    return buildAnnotatedString {
        var fontStyled = false
        for (part in parts) {
            if (fontStyled) {
                withStyle(style = spanStyle) {
                    append(part)
                }
            } else {
                append(part)
            }
            fontStyled = !fontStyled
        }
    }
}