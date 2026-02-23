package com.example.greenflag.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.greenflag.ui.screens.welcome.SuccessScreen
import com.example.greenflag.ui.screens.welcome.WelcomeScreen
import com.example.greenflag.ui.screens.welcome.register.RegisterScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(
                onCreateAccount = { navController.navigate("register") }
            )
        }
        composable("register") {
            RegisterScreen(
                onBack = { navController.popBackStack() },
                onNext = { email, password ->
                    // Simulate success → pass email to success screen
                    navController.navigate("success/$email") {
                        // Optional: clear back stack so user can't go back to register
                        popUpTo("register") { inclusive = true }
                    }
                }
            )
        }
        composable(
            route = "success/{email}",
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            SuccessScreen(
                email = email,
                onBack = { navController.popBackStack() },
                onContinue = {
                    // TODO: navigate to home/dashboard or login
                    navController.navigate("home") {
                        popUpTo("welcome") { inclusive = true }
                    }
                }
            )
        }
    }
}