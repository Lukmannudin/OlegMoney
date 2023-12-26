package com.ludi.olegmoney.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ludi.olegmoney.R
import com.ludi.olegmoney.ui.material.*
import com.ludi.olegmoney.ui.theme.Dimens
import com.ludi.olegmoney.ui.theme.OlegColor
import com.ludi.olegmoney.ui.theme.OlegTheme

@Preview
@Composable
fun LoginPreview() {
    OlegTheme {
        LoginScreen(onBack = {}, onSignUp = {}, loginViewModel = viewModel())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onBack: () -> Unit,
    onSignUp: () -> Unit,
    loginViewModel: LoginViewModel
) {
    OlegTheme {
        val name = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val passwordVisible = remember { mutableStateOf(false) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            textAlign = TextAlign.Center,
                            text = stringResource(id = R.string.login),
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
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(56.dp))

                OlegTextField(name = stringResource(id = R.string.name), state = name)

                Spacer(modifier = Modifier.height(Dimens.spacingXXS))

                OlegPasswordTextField(
                    label = stringResource(id = R.string.password),
                    state = password,
                    passwordVisibleState = passwordVisible
                )

                Spacer(modifier = Modifier.height(Dimens.spacingXXL))

                PrimaryButton(text = stringResource(id = R.string.login)) {
                    loginViewModel.login(
                        name.value,
                        password.value
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = stringResource(id = R.string.forgot_password),
                    color = OlegColor.Violet100,
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(38.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.dont_have_an_account_yet),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    OlegClickableText(text = stringResource(id = R.string.sign_up)) {
                        onSignUp.invoke()
                    }
                }
            }
        }
    }
}