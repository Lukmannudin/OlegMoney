package com.lukmannudin.olegmoney.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lukmannudin.olegmoney.ui.layout.SignupScreen
import com.lukmannudin.olegmoney.ui.onboarding.OnboardingScreen
import com.lukmannudin.olegmoney.ui.onboarding.SignInScreen

@Composable
fun OlegMoneyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Navigations.SIGNIN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Navigations.ONBOARDING) {
            OnboardingScreen(
                onNavigateToSignup = {
                    navController.navigate(Navigations.SIGNUP)
                }
            )
        }
        composable(Navigations.SIGNUP) {
            SignupScreen(
                onBack = { navController.navigate(Navigations.SIGNUP) }
            )
        }
        composable(Navigations.SIGNIN) {
            SignInScreen(
                onBack = { navController.navigate(Navigations.SIGNIN) }
            )
        }
    }
}