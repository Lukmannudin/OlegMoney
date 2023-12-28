package com.ludi.olegmoney.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ludi.olegmoney.R
import com.ludi.olegmoney.ui.material.PinTextField
import com.ludi.olegmoney.ui.material.PrimaryButton
import com.ludi.olegmoney.ui.theme.Dimens
import com.ludi.olegmoney.ui.theme.FontInter
import com.ludi.olegmoney.ui.theme.OlegColor
import com.ludi.olegmoney.ui.theme.OlegTheme
import com.ludi.olegmoney.ui.theme.TextSize
import com.ludi.olegmoney.util.annotatedString

@Preview
@Composable
fun VerificationPreview() {
    OlegTheme {
        VerificationScreen(
            onBack = {},
            email = ""
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationScreen(
    onBack: () -> Unit,
    email: String
) {
    val pin = remember { mutableStateOf("") }
    val timeLeft = remember { mutableStateOf("00:00") }

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.verification),
                style = MaterialTheme.typography.titleMedium
            )
        }, navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.Filled.ArrowBack, "backButton")
            }
        })
    }) { contentPadding ->
        OlegTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.spacing),
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(contentPadding.calculateTopPadding()))

                Text(
                    text = stringResource(id = R.string.enter_your_verification_code),
                    style = TextStyle(
                        fontFamily = FontInter,
                        fontWeight = FontWeight.Normal,
                        fontSize = TextSize.heading,
                        color = OlegColor.Dark100
                    )
                )

                Spacer(modifier = Modifier.height(54.dp))

                PinTextField(pinState = pin)

                Spacer(modifier = Modifier.height(48.dp))

                Text(
                    text = timeLeft.value,
                    style = MaterialTheme.typography.bodyLarge.plus(TextStyle(color = OlegColor.Violet100))
                )

                Spacer(modifier = Modifier.height(Dimens.spacing))

                val description = stringResource(
                    id = R.string.we_send_verification_code_to_your_email, email
                )
                Text(
                    text = description.annotatedString(
                        SpanStyle(color = OlegColor.Violet100), email
                    ), style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(Dimens.spacing))

                Text(
                    text = stringResource(id = R.string.i_didnt_received_the_code),
                    style = MaterialTheme.typography.bodyMedium.plus(
                        TextStyle(
                            color = OlegColor.Violet100, textDecoration = TextDecoration.Underline
                        )
                    )
                )

                Spacer(modifier = Modifier.height(46.dp))

                PrimaryButton(
                    text = stringResource(id = R.string.verify)
                ) {

                }
            }
        }
    }
}