package com.lukmannudin.olegmoney.ui.material

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.lukmannudin.olegmoney.ui.theme.OlegColor
import com.lukmannudin.olegmoney.ui.theme.Shapes

@Composable
fun FilledButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = OlegColor.Violet),
        shape = Shapes.medium,
        content = { LocalTextStyle(text = text, Color.White) }
    )
}

@Composable
fun FilledTonalButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = OlegColor.LightViolet),
        shape = Shapes.medium,
        content = { LocalTextStyle(text = text, OlegColor.Violet) }
    )
}

@Composable
private fun LocalTextStyle(text: String, color: Color) {
    ProvideTextStyle(
        value = TextStyle(color = color)
    ) {
        Text(text = text)
    }
}