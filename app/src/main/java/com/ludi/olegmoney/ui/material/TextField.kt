package com.ludi.olegmoney.ui.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ludi.olegmoney.ui.theme.Dimens
import com.ludi.olegmoney.ui.theme.OlegColor
import com.ludi.olegmoney.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OlegTextField(
    name: String,
    state: MutableState<String>,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(value = state.value, onValueChange = {
        state.value = it
    }, label = {
        Text(name, style = MaterialTheme.typography.bodyMedium)
    }, colors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = OlegColor.FloralWhite, focusedBorderColor = OlegColor.Violet
    ), shape = Shapes.medium, modifier = modifier.fillMaxWidth()
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
    OutlinedTextField(value = state.value, onValueChange = {
        state.value = it
    }, label = {
        Text(name, style = MaterialTheme.typography.bodyMedium)
    }, colors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = OlegColor.FloralWhite, focusedBorderColor = OlegColor.Violet
    ), shape = Shapes.medium, visualTransformation = if (passwordVisibleState.value) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }, trailingIcon = {
        val image = if (passwordVisibleState.value) {
            Icons.Filled.Visibility
        } else {
            Icons.Filled.VisibilityOff
        }

        val description = if (passwordVisibleState.value) "Hide password" else "Show password"

        IconButton(onClick = { passwordVisibleState.value = !passwordVisibleState.value }) {
            Icon(imageVector = image, contentDescription = description)
        }
    }, modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun PinTextField(
    modifier: Modifier = Modifier,
    pinState: MutableState<String> = remember { mutableStateOf("") },
    maxDigit: Int = 6
) {
    val focusRequester = remember { FocusRequester() }

    BasicTextField(
        modifier = modifier
            .height(40.dp)
            .focusRequester(focusRequester),
        value = pinState.value,
        onValueChange = {
        if (it.length <= maxDigit) {
            pinState.value = it
        }
    }, keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.NumberPassword
    ), decorationBox = {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(40.dp)
        ) {
            repeat(maxDigit) { index ->
                val char = when {
                    index >= pinState.value.length -> ""
                    else -> pinState.value[index].toString()
                }

                if (char.isNotEmpty()) {
                    Text(
                        text = char,
                        style = MaterialTheme.typography.titleLarge,
                        color = OlegColor.Dark75,
                        textAlign = TextAlign.Center,
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(Dimens.spacing)
                            .clip(CircleShape)
                            .background(OlegColor.Light20),
                    )
                }

                Spacer(modifier = Modifier.width(Dimens.spacing))
            }
        }
    })

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}