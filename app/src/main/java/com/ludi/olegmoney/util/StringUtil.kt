package com.ludi.olegmoney.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString

fun String.annotatedString(style: SpanStyle, argument: String): AnnotatedString {
    val indexArgument = indexOf(argument)
    val lastIndexArgument = indexArgument + argument.length

    return buildAnnotatedString {
        append(this@annotatedString)
        addStyle(style, indexArgument, lastIndexArgument)
    }
}