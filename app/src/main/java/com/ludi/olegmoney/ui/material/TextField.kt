package com.ludi.olegmoney.ui.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ludi.olegmoney.ui.theme.Dimens
import com.ludi.olegmoney.ui.theme.OlegColor
import com.ludi.olegmoney.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OlegTextField(
    name: String,
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit = {}
) {

    var value by remember { mutableStateOf("") }

    OutlinedTextField(value = value, onValueChange = {
        value = it
        onValueChanged(it)
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
    label: String,
    onValueChanged: (String) -> Unit,
) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(value = password, onValueChange = {
        password = it
        onValueChanged(it)
    }, label = {
        Text(label, style = MaterialTheme.typography.bodyMedium)
    }, colors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = OlegColor.FloralWhite, focusedBorderColor = OlegColor.Violet
    ), shape = Shapes.medium, visualTransformation = if (passwordVisible) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }, trailingIcon = {
        val image = if (passwordVisible) {
            Icons.Filled.Visibility
        } else {
            Icons.Filled.VisibilityOff
        }

        val description = if (passwordVisible) "Hide password" else "Show password"

        IconButton(onClick = { passwordVisible = !passwordVisible }) {
            Icon(imageVector = image, contentDescription = description)
        }
    }, modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun PinTextField(
    modifier: Modifier = Modifier,
    maxDigit: Int = 6,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onPinChanged: (String) -> Unit = {}
) {

    var pinState by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    BasicTextField(modifier = modifier
        .height(40.dp)
        .focusRequester(focusRequester),
        value = pinState,
        onValueChange = {
            if (it.length <= maxDigit) {
                pinState = it
                onPinChanged(it)
            }
        },
        keyboardOptions = keyboardOptions,
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(40.dp)
            ) {
                repeat(maxDigit) { index ->
                    val char = when {
                        index >= pinState.length -> ""
                        else -> pinState[index].toString()
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

@Preview
@Composable
fun pinTextView() {
    PinTextField()
}