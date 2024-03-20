package com.ludi.olegmoney.ui.onboarding.addnewaccount

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ludi.olegmoney.ui.components.OlegDropdownMenu
import com.ludi.olegmoney.ui.components.textfield.OlegTextField
import com.ludi.olegmoney.ui.theme.OlegTheme

@Composable
fun AddNewAccount() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OlegTheme.color.Violet100)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
        ) {
            Text(
                text = "Balance",
                style = OlegTheme.typography.title3,
                color = OlegTheme.color.Light80
            )

            Spacer(modifier = Modifier.height(OlegTheme.spacing.spacing4))

            Text(
                text = "$00.0",
                style = OlegTheme.typography.titleX,
                color = OlegTheme.color.Light80
            )

            Spacer(modifier = Modifier.height(OlegTheme.spacing.spacing3))

            Surface(
                color = Color.White,
                shape = OlegTheme.shapes.medium,
            ) {
                Column(
                    modifier = Modifier.padding(
                        horizontal = OlegTheme.spacing.spacing5,
                        vertical = OlegTheme.spacing.spacing7,
                    )
                ) {
                    OlegTextField(
                        value = "Name",
                    )

                    Spacer(modifier = Modifier.height(OlegTheme.spacing.spacing5))

                    OlegDropdownMenu(
                        label = "Account Type", options = listOf("Rupiah", "Dollar", "Euro", "Pounds", "Yen"))
                }
            }
        }
    }
}

@Preview
@Composable
fun AddNewAccountPreview() {
    OlegTheme {
        AddNewAccount()
    }
}