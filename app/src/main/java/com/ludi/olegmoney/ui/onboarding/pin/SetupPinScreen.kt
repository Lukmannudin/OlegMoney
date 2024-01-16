package com.ludi.olegmoney.ui.onboarding.pin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ludi.olegmoney.ui.material.textfield.PinTextField
import com.ludi.olegmoney.ui.theme.OlegColor
import com.ludi.olegmoney.ui.theme.OlegTheme

@Composable
fun SetupPinScreen() {
    val keys = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "\u2192")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(OlegColor.Violet100),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(46.dp))

        Text(
            color = OlegColor.Light80,
            text = "Let’s  setup your PIN"
        )

        Spacer(modifier = Modifier.height(92.dp))

        PinTextField(
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
@Preview
fun SetupPinScreenPreview() {
    OlegTheme {
        SetupPinScreen()
    }
}