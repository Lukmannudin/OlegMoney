package com.lukmannudin.olegmoney.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lukmannudin.olegmoney.ui.DotsIndicator
import com.lukmannudin.olegmoney.ui.material.FilledButton
import com.lukmannudin.olegmoney.ui.material.FilledTonalButton
import com.lukmannudin.olegmoney.ui.theme.Dimens
import com.lukmannudin.olegmoney.R
import com.lukmannudin.olegmoney.ui.theme.OlegTheme

@Composable
fun ViewLogin() {
    OlegTheme {
        LoginLayout()
    }
}

@Composable
private fun LoginLayout() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.spacingXXL),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val imageModifier = Modifier
                .size(132.dp)


            Image(
                painter = painterResource(id = R.drawable.ic_holding_money_big),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = imageModifier
            )
            Spacer(modifier = Modifier.height(Dimens.SpacingXXXXL))

            Text(
                text = stringResource(id = R.string.gain_total_control_of_your_money),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(Dimens.SpacingXL))

            Text(
                text = stringResource(id = R.string.become_your_own_money_manager_and_make_every_cent_count),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(Dimens.SpacingXXXL))

            DotsIndicator(
                totalDots = 3,
                selectedIndex = 0,
                selectedColor = colorResource(id = R.color.violet),
                unSelectedColor = colorResource(id = R.color.light_violet)
            )

            Spacer(modifier = Modifier.height(Dimens.SpacingXXXL))

            FilledButton(text = stringResource(id = R.string.sign_up)) {}
            FilledTonalButton(text = stringResource(id = R.string.login)) {}
        }
    }
}