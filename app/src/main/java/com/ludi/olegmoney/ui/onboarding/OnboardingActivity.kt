package com.ludi.olegmoney.ui.onboarding

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.ludi.olegmoney.R
import com.ludi.olegmoney.ui.OlegMoneyNavHost
import com.ludi.olegmoney.ui.theme.OlegTheme
import com.lukmannudin.sharedkmm.Greeting
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : ComponentActivity() {

    val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, Greeting().greet(), Toast.LENGTH_SHORT).show()
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


