package com.example.studyhub.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.studyhub.screens.HistoryQuiz

class HistoryViewModel : ViewModel() {
    // State list yang akan menyimpan seluruh riwayat kuis selama aplikasi terbuka
    val historyList = mutableStateListOf<HistoryQuiz>()

    fun tambahRiwayat(matkul: String, nilai: Int) {
        // Mencegah data duplikat "Belum Ada" masuk ke list
        if (matkul != "Belum Ada") {
            historyList.add(HistoryQuiz(matkul = matkul, nilai = nilai))
        }
    }
}