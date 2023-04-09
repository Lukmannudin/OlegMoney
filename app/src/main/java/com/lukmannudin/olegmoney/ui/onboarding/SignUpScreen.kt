package com.lukmannudin.olegmoney.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lukmannudin.olegmoney.R
import com.lukmannudin.olegmoney.ui.material.*
import com.lukmannudin.olegmoney.ui.theme.Dimens
import com.lukmannudin.olegmoney.ui.theme.OlegColor
import com.lukmannudin.olegmoney.ui.theme.OlegTheme
import com.lukmannudin.olegmoney.ui.util.parseFont

@Preview
@Composable
fun SignupPreview() {
    OlegTheme {
        SignupScreen(onBack = {})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(
    onBack: () -> Unit
) {
    OlegTheme {
        val name = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val passwordVisible = remember{ mutableStateOf(false) }
        val readCondition = remember { mutableStateOf(false) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            textAlign = TextAlign.Center,
                            text = stringResource(id = R.string.sign_up),
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.Filled.ArrowBack, "backButton")
                        }
                    }
                )
            }
        ) { contentPadding ->
            Column(
                Modifier.padding(Dimens.spacing, contentPadding.calculateTopPadding()),
            ) {
                Spacer(modifier = Modifier.height(56.dp))

                OlegTextField(name = stringResource(id = R.string.name), state = name)

                Spacer(modifier = Modifier.height(Dimens.spacingXXS))

                OlegTextField(name = stringResource(id = R.string.email), state = email)

                Spacer(modifier = Modifier.height(Dimens.spacingXXS))

                OlegPasswordTextField(
                    name = stringResource(id = R.string.password),
                    state = password,
                    passwordVisibleState = passwordVisible
                )

                Spacer(modifier = Modifier.height(Dimens.spacingXXS))

                CheckboxWithText(
                    checkState = readCondition,
                    annotatedString = stringResource(id = R.string.signup_terms_condition).parseFont(
                        spanStyle = SpanStyle(color = OlegColor.Violet)
                    )
                )

                Spacer(modifier = Modifier.height(Dimens.spacingXS))

                OlegFilledButton(text = stringResource(id = R.string.sign_up)) { }

                Spacer(modifier = Modifier.height(Dimens.spacingXXS))

                Text(
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    text = "Or with",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(Dimens.spacingXXS))

                OlegOutlinedButton(
                    text = stringResource(id = R.string.signup_with_google),
                    iconRes = R.drawable.ic_google
                ) {}

                Spacer(modifier = Modifier.height(Dimens.SpacingXL))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.already_have_an_account), style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = stringResource(id = R.string.login),
                        style = MaterialTheme.typography.bodyMedium,
                        color = OlegColor.Violet
                    )
                }
            }
        }
    }
}

