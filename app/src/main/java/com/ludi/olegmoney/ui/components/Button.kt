package com.ludi.olegmoney.ui.components

import android.annotation.SuppressLint
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ludi.olegmoney.R
import com.ludi.olegmoney.ui.theme.Dimens
import com.ludi.olegmoney.ui.theme.OlegTheme
import com.ludi.olegmoney.ui.theme.Shapes

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: Style = Style.LARGE,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit = {},
) {
    ButtonView(
        modifier = modifier.getModifierSize(style),
        color = OlegTheme.color.Violet100,
        textColor = OlegTheme.color.Light80,
        text = text,
        onClick = onClick,
        enabled = enabled,
        iconRes = iconRes,
        iconColor = OlegTheme.color.Light80,
        style = style
    )
}

@Composable
fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: Style = Style.LARGE,
    iconRes: Int? = null,
    onClick: () -> Unit = {},
) {
    ButtonView(
        modifier = modifier.getModifierSize(style),
        color = OlegTheme.color.Violet20,
        textColor = OlegTheme.color.Violet100,
        text = text,
        enabled = enabled,
        onClick = onClick,
        iconRes = iconRes,
        iconColor = OlegTheme.color.Violet100,
        style = style
    )
}


@Composable
fun TertiaryButton(
    text: String,
    modifier: Modifier = Modifier,
    style: Style = Style.LARGE,
    enabled: Boolean = true,
    iconRes: Int? = null,
    onClick: () -> Unit = {},
) {
    OutlinedButton(modifier = modifier
        .getModifierSize(style)
        .height(dimensionResource(id = getButtonHeight(style))),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = OlegTheme.color.Light60),
        shape = Shapes.medium,
        enabled = enabled,
        border = BorderStroke(1.dp, OlegTheme.color.Light60),
        content = {
            if (iconRes != null) {
                val iconNormal = dimensionResource(id = R.dimen.icon_normal)
                val iconLarge = dimensionResource(id = R.dimen.icon_large)

                Icon(
                    modifier = Modifier
                        .widthIn(min = iconNormal, max = iconLarge)
                        .heightIn(min = iconNormal, max = iconLarge),
                    painter = painterResource(id = iconRes),
                    tint = OlegTheme.color.dark50,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(OlegTheme.spacing.spacing3))
            }

            Text(
                text = text, style = getTextStyle(style = style), color = OlegTheme.color.dark50
            )
        }
    )
}

@SuppressLint("UnnecessaryComposedModifier")
private fun Modifier.getModifierSize(style: Style): Modifier = composed {
    val customModifier = if (style == Style.LARGE) {
        then(Modifier.fillMaxWidth())
    } else Modifier.wrapContentWidth()
    then(customModifier)
}

@DimenRes
private fun getButtonHeight(style: Style): Int {
    return if (style == Style.PILLS) {
        R.dimen.button_pill_height
    } else {
        R.dimen.button_height
    }
}

@Composable
private fun getTextStyle(style: Style): TextStyle {
    return if (style == Style.PILLS) {
        OlegTheme.typography.regular3
    } else {
        OlegTheme.typography.title3
    }
}

@Composable
fun ButtonView(
    style: Style,
    modifier: Modifier,
    color: Color,
    textColor: Color,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    iconRes: Int?,
    iconColor: Color?
) {

    Button(
        modifier = modifier.height(dimensionResource(id = getButtonHeight(style))),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = Shapes.medium,
        enabled = enabled,
        content = {
            if (iconRes != null) {
                val iconNormal = dimensionResource(id = R.dimen.icon_normal)
                val iconLarge = dimensionResource(id = R.dimen.icon_large)

                Icon(
                    modifier = Modifier
                        .widthIn(min = iconNormal, max = iconLarge)
                        .heightIn(min = iconNormal, max = iconLarge),
                    painter = painterResource(id = iconRes),
                    tint = iconColor ?: OlegTheme.color.Light80,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(OlegTheme.spacing.spacing3))
            }

            Text(
                text = text,
                style = getTextStyle(style = style),
                color = textColor
            )
        })
}

@Composable
fun OlegOutlinedButton(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    OutlinedButton(modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = Shapes.medium,
        border = BorderStroke(1.dp, OlegTheme.color.Light60),
        content = { LocalTextStyle(text = text, OlegTheme.color.dark50, iconRes) })
}

@Composable
private fun LocalTextStyle(
    text: String, color: Color, @DrawableRes idRes: Int? = null
) {
    ProvideTextStyle(
        value = TextStyle(color = color)
    ) {
        val imageModifier = Modifier.size(32.dp)

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

enum class Style {
    LARGE, SMALL, PILLS
}

@Preview
@Composable
fun LargeButtonsPreview() {
    OlegTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryButton(text = "Primary")
            SecondaryButton(text = "Secondary")
            TertiaryButton(text = "Tertiary") {}
        }
    }
}

@Preview
@Composable
fun LargeButtonsWithIconPreview() {
    OlegTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryButton(
                text = "Primary",
                iconRes = R.drawable.ic_add
            )
            SecondaryButton(
                text = "Secondary",
                iconRes = R.drawable.ic_add
            )
            TertiaryButton(
                text = "Tertiary",
                iconRes = R.drawable.ic_add
            )
        }
    }
}

@Preview
@Composable
fun SmallButtonsPreview() {
    OlegTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryButton(
                text = "Primary",
                style = Style.SMALL,
            )
            SecondaryButton(text = "Secondary", style = Style.SMALL)
            TertiaryButton(text = "Tertiary", style = Style.SMALL)
        }
    }
}

@Preview
@Composable
fun PillsButtonsPreview() {
    OlegTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryButton(text = "Primary", style = Style.PILLS)
            SecondaryButton(text = "Secondary", style = Style.PILLS)
            TertiaryButton(text = "Tertiary", style = Style.PILLS)
        }
    }
}
