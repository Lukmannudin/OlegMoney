package com.lukmannudin.olegmoney.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lukmannudin.olegmoney.ui.OlegMoneyNavHost
import com.lukmannudin.olegmoney.ui.layout.LoginScreen
import com.lukmannudin.olegmoney.ui.theme.OlegTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlegTheme {
                OlegMoneyNavHost()
            }
        }
    }
}

