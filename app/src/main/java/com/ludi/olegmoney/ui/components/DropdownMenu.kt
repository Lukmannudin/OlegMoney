package com.ludi.olegmoney.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ludi.olegmoney.R
import com.ludi.olegmoney.ui.theme.OlegTheme

@Composable
fun OlegDropdownMenu(
    label: String,
    options: List<String>,
    modifier: Modifier = Modifier,
    onClickItem: () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier,
        shape = OlegTheme.shapes.medium,
        border = BorderStroke(
            width = 1.dp,
            color = OlegTheme.color.Light20
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = OlegTheme.spacing.spacing5,
                    vertical = OlegTheme.spacing.spacing4
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = OlegTheme.typography.regular1,
                color = OlegTheme.color.Light20,
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = "More",
                    tint = OlegTheme.color.Light20
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = option,
                                style = OlegTheme.typography.regular1,
                                color = OlegTheme.color.Light20,
                            )
                        },
                        onClick = onClickItem
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun OlegDropdownMenuPreview() {
    OlegTheme {
        OlegDropdownMenu(
            label = "Americano",
            options = listOf("Americano", "Cappucino", "Mochachino")
        )
    }
}