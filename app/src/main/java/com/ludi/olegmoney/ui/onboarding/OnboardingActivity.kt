package com.ludi.olegmoney.ui.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.ludi.olegmoney.R
import com.ludi.olegmoney.ui.OlegMoneyNavHost
import com.ludi.olegmoney.ui.theme.OlegTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : ComponentActivity() {

    val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlegTheme {
                OlegMoneyNavHost()
            }
        }

        setupGoogleService()
    }

    private fun setupGoogleService() {
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(getString(R.string.gcp_id))
            .requestId()
            .requestProfile()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        viewModel.mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }
}


