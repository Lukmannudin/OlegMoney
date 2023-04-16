package com.lukmannudin.olegmoney.ui.material

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.lukmannudin.olegmoney.ui.theme.Dimens
import com.lukmannudin.olegmoney.ui.theme.OlegColor
import com.lukmannudin.olegmoney.ui.theme.Shapes

@Composable
fun PrimaryButton(
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
fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = OlegColor.Violet20),
        shape = Shapes.medium,
        content = { LocalTextStyle(text = text, OlegColor.Violet100) }
    )
}

@Composable
fun PlainButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = OlegColor.Violet100),
        shape = Shapes.medium,
        content = { LocalTextStyle(text = text, OlegColor.Light80) }
    )
}

@Composable
fun OlegOutlinedButton(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = Shapes.medium,
        border = BorderStroke(1.dp, OlegColor.Light60),
        content = { LocalTextStyle(text = text, OlegColor.Dark50, iconRes) }
    )
}

@Composable
private fun LocalTextStyle(
    text: String,
    color: Color,
    @DrawableRes idRes: Int? = null
) {
    ProvideTextStyle(
        value = TextStyle(color = color)
    ) {
        val imageModifier = Modifier
            .size(32.dp)

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (idRes != null) {
                Image(
                    painter = painterResource(id = idRes),
                    contentDescription = "",
                    modifier = imageModifier,
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.width(Dimens.spacingXXS))
            }
            Text(text = text)
        }
    }
}