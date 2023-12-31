package com.ludi.olegmoney.ui.onboarding.login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ludi.olegmoney.R
import com.ludi.olegmoney.ui.material.*
import com.ludi.olegmoney.ui.material.textfield.OlegPasswordTextField
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
        var name by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val uiState by loginViewModel.loginUiState.collectAsStateWithLifecycle()

        uiState?.let { state ->
            when (state) {
                is LoginUiState.OnSuccess -> {
                    Toast.makeText(LocalContext.current,"login success", Toast.LENGTH_SHORT).show()
                }
                is LoginUiState.OnError -> {
                    Toast.makeText(LocalContext.current,"login failed", Toast.LENGTH_SHORT).show()
                }

                LoginUiState.OnLoading -> Toast.makeText(LocalContext.current, "loading", Toast.LENGTH_SHORT).show()
            }
        }

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

                OlegTextField(name = stringResource(id = R.string.name)) {
                    name = it
                }

                Spacer(modifier = Modifier.height(Dimens.spacingXXS))

                OlegPasswordTextField(
                    label = stringResource(id = R.string.password),
                ) {
                    password = it
                }

                Spacer(modifier = Modifier.height(Dimens.spacingXXL))

                PrimaryButton(text = stringResource(id = R.string.login)) {
                    loginViewModel.login(
                        name,
                        password
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