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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lukmannudin.olegmoney.R
import com.lukmannudin.olegmoney.ui.material.OlegTextField
import com.lukmannudin.olegmoney.ui.theme.Dimens
import com.lukmannudin.olegmoney.ui.theme.OlegTheme

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

                OlegTextField(name = "Name", state = name)

                Spacer(modifier = Modifier.height(Dimens.spacingXXS))

                OlegTextField(name = "Email", state = email)

                Spacer(modifier = Modifier.height(Dimens.spacingXXS))

                OlegTextField(name = "Password", state = password)
            }
        }
    }
}

