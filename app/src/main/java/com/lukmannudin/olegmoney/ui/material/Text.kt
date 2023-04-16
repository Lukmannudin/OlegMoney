package com.lukmannudin.olegmoney.ui.material

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import com.lukmannudin.olegmoney.ui.theme.OlegColor

@Composable
fun OlegClickableText(
    text: String,
    color: Color = OlegColor.Violet100,
    onClick: () -> Unit
) {
    ClickableText(
        text = AnnotatedString(text),
        style = MaterialTheme.typography.bodyMedium.plus(TextStyle(color = color))
    ) {
        onClick.invoke()
    }
}