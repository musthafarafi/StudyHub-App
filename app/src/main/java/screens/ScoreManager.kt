package com.example.studyhub.data

import androidx.compose.runtime.mutableStateListOf

object ScoreManager {

    val scoreHistory = mutableStateListOf<Int>()

    fun addScore(score: Int) {
        scoreHistory.add(score)
    }

}