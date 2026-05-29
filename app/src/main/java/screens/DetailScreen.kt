package com.example.studyhub.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(
    materi: String,
    onStartQuiz: (String) -> Unit
) {

    val judul = when (materi) {
        "algoritma" -> "Algoritma Dasar"
        "database" -> "Database"
        else -> "Jaringan Komputer"
    }

    val isiMateri = when (materi) {

        "algoritma" ->
            "Algoritma adalah langkah-langkah logis dan sistematis untuk menyelesaikan suatu masalah."

        "database" ->
            "Database digunakan untuk menyimpan, mengelola, dan mengambil data secara efisien."

        else ->
            "Jaringan komputer adalah sistem yang menghubungkan beberapa perangkat untuk berbagi data."
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F172A),
                        Color(0xFF1E293B)
                    )
                )
            )
            .padding(20.dp)
    ) {

        Text(
            text = judul,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF334155)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Materi",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = isiMateri,
                    color = Color.LightGray,
                    fontSize = 17.sp
                )

            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                onStartQuiz(materi)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2563EB)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Mulai Quiz",
                fontSize = 18.sp
            )

        }

    }

}