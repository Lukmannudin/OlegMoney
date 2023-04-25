package com.ludi.olegmoney.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ludi.olegmoney.ui.onboarding.SignupScreen
import com.ludi.olegmoney.ui.onboarding.OnboardingScreen
import com.ludi.olegmoney.ui.onboarding.LoginScreen

@Composable
fun OlegMoneyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Navigations.ONBOARDING
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
                },
                onNavigateToLogin = {
                    navController.navigate(Navigations.LOGIN)
                }
            )
        }
        composable(Navigations.SIGNUP) {
            SignupScreen(
                onBack = { navController.navigate(Navigations.ONBOARDING) },
                onLogin = { navController.navigate(Navigations.LOGIN) }
            )
        }
        composable(Navigations.LOGIN) {
            LoginScreen(
                onBack = { navController.navigate(Navigations.ONBOARDING) },
                onSignUp = { navController.navigate(Navigations.SIGNUP) }
            )
        }
    }
}