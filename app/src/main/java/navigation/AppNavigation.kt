package com.example.studyhub.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studyhub.screens.*
import com.example.studyhub.viewmodel.HistoryViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // Inisialisasi ViewModel di sini agar datanya bertahan di seluruh screen
    val historyViewModel: HistoryViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(onStartClick = { navController.navigate("home") })
        }

        composable("home") {
            HomeScreen(
                onMaterialClick = { materi -> navController.navigate("quiz/$materi") },
                onHistoryClick = {
                    // Masuk ke history tanpa membawa data baru (hanya melihat yang ada)
                    navController.navigate("history")
                }
            )
        }

        composable("quiz/{materi}") { backStackEntry ->
            val materi = backStackEntry.arguments?.getString("materi") ?: ""
            QuizScreen(
                materi = materi,
                onFinishQuiz = { score ->
                    navController.navigate("result/$materi/$score")
                }
            )
        }

        composable("result/{materi}/{score}") { backStackEntry ->
            val materi = backStackEntry.arguments?.getString("materi") ?: ""
            val score = backStackEntry.arguments?.getString("score")?.toInt() ?: 0

            ResultScreen(
                score = score,
                onBackHome = {
                    // 1. SIMPAN ke ViewModel sebelum pindah halaman
                    historyViewModel.tambahRiwayat(materi, score)

                    // 2. Langsung buka halaman history
                    navController.navigate("history") {
                        popUpTo("home")
                    }
                }
            )
        }

        // Jalur ke history sekarang dibuat simpel kembali tanpa perlu nempel argumen di rute
        composable("history") {
            HistoryScreen(
                historyViewModel = historyViewModel,
                onBackToHome = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }
    }
}