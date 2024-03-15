package com.ludi.olegmoney.ui.onboarding.setupaccount

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ludi.olegmoney.R
import com.ludi.olegmoney.ui.material.PrimaryButton
import com.ludi.olegmoney.ui.theme.FontInter

@Composable
fun SetupAccount() {
    Column(
        modifier = Modifier.padding(
            horizontal = dimensionResource(id = R.dimen.normal)
        )
    ) {

        Spacer(modifier = Modifier.height(67.dp))

        Text(
            text = "Let’s setup your account!",
            style = TextStyle(
                fontSize = 36.sp,
                fontFamily = FontInter
            )
        )

        Spacer(modifier = Modifier.height(37.dp))

        Text(
            modifier = Modifier.weight(1f),
            text = "Account can be your bank, credit card or your wallet",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontInter
            )
        )

        PrimaryButton(text = "Let's go")

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.normal)))

    }
}

@Preview(
    showBackground = true
)
@Composable
fun SetupAccountPreview() {
    SetupAccount()
}