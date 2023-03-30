package com.lukmannudin.olegmoney.ui.material

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
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
            Text(name)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = OlegColor.FloralWhite,
            focusedBorderColor = OlegColor.Violet
        ),
        shape = Shapes.medium,
        modifier = modifier.fillMaxWidth()
    )
}