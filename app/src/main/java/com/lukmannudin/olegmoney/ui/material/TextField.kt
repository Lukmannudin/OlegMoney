package com.lukmannudin.olegmoney.ui.material

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.lukmannudin.olegmoney.ui.theme.OlegColor
import com.lukmannudin.olegmoney.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OlegTextField(
    name: String,
    state: MutableState<String>,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = {
            Text(name, style = MaterialTheme.typography.bodyMedium)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = OlegColor.FloralWhite,
            focusedBorderColor = OlegColor.Violet
        ),
        shape = Shapes.medium,
        modifier = modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OlegPasswordTextField(
    modifier: Modifier = Modifier,
    name: String,
    state: MutableState<String>,
    passwordVisibleState: MutableState<Boolean> = mutableStateOf(false),
) {
    OutlinedTextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = {
            Text(name, style = MaterialTheme.typography.bodyMedium)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = OlegColor.FloralWhite,
            focusedBorderColor = OlegColor.Violet
        ),
        shape = Shapes.medium,
        visualTransformation =
        if (passwordVisibleState.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            val image = if (passwordVisibleState.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisibleState.value) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisibleState.value = !passwordVisibleState.value}) {
                Icon(imageVector = image, contentDescription = description  )
            }
        },
        modifier = modifier.fillMaxWidth()
    )
}