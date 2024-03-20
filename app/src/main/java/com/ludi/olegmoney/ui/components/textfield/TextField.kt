package com.ludi.olegmoney.ui.components.textfield

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ludi.olegmoney.ui.theme.OlegTheme
import com.ludi.olegmoney.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OlegTextField(
    value: String,
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit = {}
) {

    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value, onValueChange = {
            text = it
            onValueChanged(it)
        }, label = {
            Text(
                text, style = MaterialTheme.typography.bodyMedium,
            )
        }, colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = OlegTheme.color.Light80,
            focusedBorderColor = OlegTheme.color.Light100
        ), shape = Shapes.medium
    )
}

@Preview
@Composable
fun OlegTextFieldPreview() {
    OlegTheme {
        OlegTextField(value = "Test")
    }
}
