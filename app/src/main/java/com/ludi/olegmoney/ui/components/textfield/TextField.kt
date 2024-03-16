package com.ludi.olegmoney.ui.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
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
import com.ludi.olegmoney.ui.theme.OlegColor
import com.ludi.olegmoney.ui.theme.OlegTheme
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
        unfocusedBorderColor = OlegTheme.color.Light80, focusedBorderColor = OlegTheme.color.Light100
    ), shape = Shapes.medium, modifier = modifier.fillMaxWidth()
    )
}
