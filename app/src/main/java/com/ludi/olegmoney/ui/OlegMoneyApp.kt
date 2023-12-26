package com.ludi.olegmoney.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.ludi.olegmoney.ui.onboarding.LoginScreen
import com.ludi.olegmoney.ui.onboarding.OnboardingScreen
import com.ludi.olegmoney.ui.onboarding.SignupScreen

@Composable
fun OlegMoneyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Navigations.ONBOARDING,
) {

    val googleSignInRequestCode = 1

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Navigations.ONBOARDING) {
            OnboardingScreen(
                onNavigateToSignup = {
                    navController.navigate(Navigations.SIGNUP)
                },
                onNavigateToLogin = {
                    navController.navigate(Navigations.LOGIN)
                }
            )
        }
        composable(Navigations.SIGNUP) {
            SignupScreen(
                onBack = { navController.navigate(Navigations.ONBOARDING) },
                onLogin = { navController.navigate(Navigations.LOGIN) },
                signUpViewModel = hiltViewModel()
            )
        }
        composable(Navigations.LOGIN) {
            LoginScreen(
                onBack = { navController.navigate(Navigations.ONBOARDING) },
                onSignUp = { navController.navigate(Navigations.SIGNUP) },
                loginViewModel = hiltViewModel()
            )
        }
    }
}

private fun handleSignInResult(task: Task<GoogleSignInAccount>) {
    try {
        val account = task.getResult(ApiException::class.java)

        // Signed in successfully, you can now access user's information from 'account'
        val displayName = account?.displayName
        val email = account?.email

        // You can also get the user's ID token, if needed
        val idToken = account?.idToken

        // Now you can perform actions like updating UI or sending the user's data to your server

    } catch (e: ApiException) {
        // Handle sign-in failure
        Log.w("OnboardingActivity", "signInResult:failed code=${e.statusCode}")

        // You can display an error message to the user or take other actions
        // based on the error code from ApiException.
    }
}