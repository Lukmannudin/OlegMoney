package com.ludi.olegmoney.ui.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ludi.olegmoney.ui.OlegMoneyNavHost
import com.ludi.olegmoney.ui.theme.OlegTheme

class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlegTheme {
                OlegMoneyNavHost()
            }
        }
    }
}


