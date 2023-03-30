package com.lukmannudin.olegmoney.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lukmannudin.olegmoney.ui.layout.LoginScreen
import com.lukmannudin.olegmoney.ui.layout.SignupScreen

@Composable
fun OlegMoneyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Navigations.LOGIN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Navigations.LOGIN) {
            LoginScreen(
                onNavigateToSignup = {
                    navController.navigate(Navigations.SIGNUP)
                }
            )
        }
        composable(Navigations.SIGNUP) {
            SignupScreen(
                onBack = { navController.navigate(Navigations.LOGIN) }
            )
        }
    }
}