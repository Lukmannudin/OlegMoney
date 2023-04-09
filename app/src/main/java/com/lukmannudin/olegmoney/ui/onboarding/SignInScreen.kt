package com.lukmannudin.olegmoney.ui.onboarding

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
import com.lukmannudin.olegmoney.ui.layout.SignupScreen
import com.lukmannudin.olegmoney.ui.material.*
import com.lukmannudin.olegmoney.ui.theme.Dimens
import com.lukmannudin.olegmoney.ui.theme.OlegColor
import com.lukmannudin.olegmoney.ui.theme.OlegTheme
import com.lukmannudin.olegmoney.ui.util.parseFont

@Preview
@Composable
fun SignupPreview() {
    OlegTheme {
        SignInScreen(onBack = {})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    onBack: () -> Unit,

) {
    OlegTheme {
        val name = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val passwordVisible = remember{ mutableStateOf(false) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            textAlign = TextAlign.Center,
                            text = stringResource(id = R.string.sign_in),
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

                OlegPasswordTextField(
                    name = stringResource(id = R.string.password),
                    state = password,
                    passwordVisibleState = passwordVisible
                )

                Spacer(modifier = Modifier.height(Dimens.spacingXXL))

                OlegFilledButton(text = stringResource(id = R.string.sign_in)) { }
            }
        }
    }
}