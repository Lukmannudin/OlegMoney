package com.lukmannudin.olegmoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lukmannudin.olegmoney.ui.layout.ViewLogin
import com.lukmannudin.olegmoney.ui.theme.OlegTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlegTheme {
                ViewLogin()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OlegTheme {
        ViewLogin()
    }
}

