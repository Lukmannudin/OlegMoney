package com.ludi.olegmoney.ui.onboarding.verification

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ludi.olegmoney.R
import com.ludi.olegmoney.ui.material.PrimaryButton
import com.ludi.olegmoney.ui.material.textfield.PinTextField
import com.ludi.olegmoney.ui.theme.Dimens
import com.ludi.olegmoney.ui.theme.FontInter
import com.ludi.olegmoney.ui.theme.OlegColor
import com.ludi.olegmoney.ui.theme.OlegTheme
import com.ludi.olegmoney.ui.theme.TextSize
import com.ludi.olegmoney.util.annotatedString
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationScreen(
    onBack: () -> Unit,
    onVerify: (String, String) -> Unit,
    email: String,
    uiState: VerificationUiState
) {
    var pin by remember { mutableStateOf("") }
    var timeLeft by remember { mutableStateOf("00:00") }

    when (uiState) {
        is VerificationUiState.Idle -> {
            // do nothing
        }
        is VerificationUiState.OnError -> {
            Toast.makeText(LocalContext.current, uiState.message, Toast.LENGTH_SHORT).show()
        }
        is VerificationUiState.OnLoading -> {
            Toast.makeText(LocalContext.current, "loading...", Toast.LENGTH_SHORT).show()
        }
        is VerificationUiState.OnSuccess -> {
            Toast.makeText(LocalContext.current, "success...", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        var seconds = COUNTDOWN_IN_MINUTES * 60
        while (seconds > 0) {
            var minutes = "${seconds / 60}"
            var cSeconds = "${seconds % 60}"
            if (minutes.length == 1) {
                minutes = "0$minutes"
            }

            if (cSeconds.length == 1) {
                cSeconds = "0$cSeconds"
            }

            timeLeft = "$minutes:$cSeconds"
            delay(1000L)
            seconds--
        }
    }

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
                        fontSize = TextSize.titleX,
                        color = OlegColor.Dark100
                    )
                )

                Spacer(modifier = Modifier.height(54.dp))

                PinTextField(
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Characters
                    )
                ) {
                    pin = it
                }

                Spacer(modifier = Modifier.height(48.dp))

                Text(
                    text = timeLeft,
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
                    text = stringResource(id = R.string.verify),
                    enabled = uiState !is VerificationUiState.OnLoading
                ) {
                    onVerify(email, pin)
                }
            }
        }
    }
}

@Preview
@Composable
fun VerificationPreview() {

    val stateFlow = MutableStateFlow<VerificationUiState>(VerificationUiState.Idle)
    val uiState by stateFlow.collectAsStateWithLifecycle()

    OlegTheme {
        VerificationScreen(
            onBack = {},
            email = "",
            uiState = uiState,
            onVerify = { email, pin ->
                runBlocking {
                    stateFlow.value = VerificationUiState.OnLoading
                    delay(5000)
                    stateFlow.value = VerificationUiState.OnSuccess
                }
            }
        )
    }
}

const val COUNTDOWN_IN_MINUTES = 5