package com.ludi.olegmoney.ui.onboarding.signup

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.common.api.ApiException
import com.ludi.olegmoney.R
import com.ludi.olegmoney.data.user.request.SignUpRequest
import com.ludi.olegmoney.ui.components.CheckboxWithText
import com.ludi.olegmoney.ui.components.OlegClickableText
import com.ludi.olegmoney.ui.components.OlegOutlinedButton
import com.ludi.olegmoney.ui.components.textfield.OlegTextField
import com.ludi.olegmoney.ui.components.PrimaryButton
import com.ludi.olegmoney.ui.components.textfield.OlegPasswordTextField
import com.ludi.olegmoney.ui.theme.Dimens
import com.ludi.olegmoney.ui.theme.OlegColor
import com.ludi.olegmoney.ui.theme.OlegTheme
import com.ludi.olegmoney.ui.util.AuthResultContract
import com.ludi.olegmoney.ui.util.parseFont
import kotlinx.coroutines.launch

@Preview
@Composable
fun SignupPreview() {
    OlegTheme {
        SignupScreen(onBack = {}, onLogin = {}, onVerification = {}, signUpViewModel = viewModel())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(
    onBack: () -> Unit,
    onLogin: () -> Unit,
    onVerification: (String) -> Unit,
    signUpViewModel: SignUpViewModel
) {

    val coroutineScope = rememberCoroutineScope()
    var text by remember { mutableStateOf<String?>(null) }
    val signInRequestCode = 1
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var readCondition by remember { mutableStateOf(false) }
    val uiState by signUpViewModel.signUpState.collectAsStateWithLifecycle()
    val signUpEnabled by remember {
        mutableStateOf(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty())
    }

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = AuthResultContract()) { task ->
            try {
                val account = task?.getResult(ApiException::class.java)
                if (account == null) {
                    text = "Google sign in failed"
                } else {
                    coroutineScope.launch {
                        signUpViewModel.signUp(
                            SignUpRequest(
                                name = account.displayName ?: account.familyName
                                ?: account.givenName ?: "",
                                email = account.email!!,
                                googleId = account.id,
                                password = "",
                                avatarUrl = account.photoUrl.toString()
                            )
                        )
                    }
                }
            } catch (e: ApiException) {
                text = "Google sign in failed"
            }
        }


    when (uiState) {
        is SignUpState.OnSuccess -> {
            LaunchedEffect(Unit) {
                onVerification.invoke((uiState as SignUpState.OnSuccess).user.email)
            }
        }

        is SignUpState.OnError -> {
            Toast.makeText(
                LocalContext.current, (uiState as SignUpState.OnError).message ?: "sign up failed", Toast.LENGTH_SHORT
            ).show()
        }

        SignUpState.OnLoading ->  {
            Toast.makeText(
                LocalContext.current, "loading", Toast.LENGTH_SHORT
            ).show()
        }

        is SignUpState.Idle -> {
            // do nothing
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.sign_up),
                style = MaterialTheme.typography.titleMedium
            )
        }, navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.Filled.ArrowBack, "backButton")
            }
        })
    }) { contentPadding ->
        Column(
            Modifier.padding(Dimens.spacing, contentPadding.calculateTopPadding()),
        ) {
            Spacer(modifier = Modifier.height(56.dp))

            OlegTextField(value = stringResource(id = R.string.name)) {
                name = it
            }

            Spacer(modifier = Modifier.height(Dimens.spacingXXS))

            OlegTextField(value = stringResource(id = R.string.email)) {
                email = it
            }

            Spacer(modifier = Modifier.height(Dimens.spacingXXS))

            OlegPasswordTextField(
                label = stringResource(id = R.string.password),
            ) { value ->
                password = value
            }

            Spacer(modifier = Modifier.height(Dimens.spacingXXS))

            CheckboxWithText(
                annotatedString = stringResource(id = R.string.signup_terms_condition).parseFont(
                    spanStyle = SpanStyle(color = OlegTheme.color.Violet100)
                )
            ) {
                readCondition = it
            }

            Spacer(modifier = Modifier.height(Dimens.spacingXS))

            PrimaryButton(
                enabled = true, text = stringResource(id = R.string.sign_up)
            ) {
                signUpViewModel.signUp(
                    SignUpRequest(
                        name, email, password
                    )
                )
            }

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
                enabled = uiState !is SignUpState.OnLoading,
                iconRes = R.drawable.ic_google,
            ) {
                authResultLauncher.launch(signInRequestCode)
            }

            Spacer(modifier = Modifier.height(Dimens.SpacingXL))

            Row(
                horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.already_have_an_account),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(2.dp))
                OlegClickableText(text = stringResource(id = R.string.login)) {
                    onLogin.invoke()
                }
            }
        }
    }
}

