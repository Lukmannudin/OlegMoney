package com.lukmannudin.olegmoney.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lukmannudin.olegmoney.R
import com.lukmannudin.olegmoney.data.user.User
import com.lukmannudin.olegmoney.ui.material.PinTextField
import com.lukmannudin.olegmoney.ui.material.PrimaryButton
import com.lukmannudin.olegmoney.ui.theme.*
import com.lukmannudin.olegmoney.util.annotatedString

@Preview
@Composable
fun VerificationPreview() {
    OlegTheme {
        VerificationScreen(
            User(
                id = 1123, "Lebron James", "lebronKing@gmail.com", "", ""
            )
        ) {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationScreen(
    user: User, onBack: () -> Unit
) {
    val pin = remember { mutableStateOf("") }
    val timeLeft = remember { mutableStateOf("00:00") }
    val focusRequester = FocusRequester()

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
                    id = R.string.we_send_verification_code_to_your_email, user.email
                )
                Text(
                    text = description.annotatedString(
                        SpanStyle(color = OlegColor.Violet100), user.email
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