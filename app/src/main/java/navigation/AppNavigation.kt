package com.example.studyhub.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.studyhub.screens.*
import com.example.studyhub.viewmodel.HistoryViewModel
import com.example.studyhub.screens.LoginScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val historyViewModel: HistoryViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("splash") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("splash") {
            SplashScreen(
                onStartClick = {
                    navController.navigate("home")
                }
            )
        }

        composable("home") {
            HomeScreen(
                onMaterialClick = { materi ->
                    navController.navigate("detail_materi/$materi")
                },
                onHistoryClick = {
                    navController.navigate("history")
                }
            )
        }

        composable(
            route = "detail_materi/{materi}",
            arguments = listOf(
                navArgument("materi") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val materi =
                backStackEntry.arguments?.getString("materi") ?: ""

            DetailMateriScreen(
                materiName = materi,
                onStartQuiz = {
                    navController.navigate("quiz/$materi")
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("quiz/{materi}") { backStackEntry ->

            val materi =
                backStackEntry.arguments?.getString("materi") ?: ""

            QuizScreen(
                materi = materi,
                onFinishQuiz = { score ->
                    navController.navigate("result/$materi/$score")
                }
            )
        }

        composable("result/{materi}/{score}") { backStackEntry ->

            val materi =
                backStackEntry.arguments?.getString("materi") ?: ""

            val score =
                backStackEntry.arguments?.getString("score")?.toInt() ?: 0

            ResultScreen(
                score = score,
                onBackHome = {

                    historyViewModel.tambahRiwayat(
                        materi,
                        score
                    )

                    navController.navigate("history")
                }
            )
        }

        composable("history") {
            HistoryScreen(
                historyViewModel = historyViewModel,
                onBackToHome = {
                    navController.navigate("home") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}