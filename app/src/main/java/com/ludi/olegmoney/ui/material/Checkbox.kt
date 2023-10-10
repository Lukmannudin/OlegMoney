package com.ludi.olegmoney.ui.material

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import com.ludi.olegmoney.util.TestTag

@Composable
fun CheckboxWithText(
    checkState: MutableState<Boolean> = remember { mutableStateOf(false) },
    text: String = "",
    annotatedString: AnnotatedString? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            modifier = Modifier.testTag(TestTag.CHECKBOX),
            checked = checkState.value,
            onCheckedChange = {
                checkState.value = it
            }
        )

        val style = MaterialTheme.typography.bodyLarge

        annotatedString?.let {
            Text(text = it, style = style)
        } ?: kotlin.run {
            Text(text = text, style = style)
        }
    }
}