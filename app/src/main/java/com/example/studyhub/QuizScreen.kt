package com.example.studyhub.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyhub.data.ScoreManager

data class Question(
    val question: String,
    val options: List<String>,
    val answer: String
)

@Composable
fun QuizScreen(
    materi: String,
    onFinishQuiz: (Int) -> Unit
) {

    val questions = when (materi.trim()) {

        "Algoritma Dasar" -> listOf(

            Question(
                question = "Apa itu algoritma?",
                options = listOf(
                    "Bahasa Pemrograman",
                    "Langkah penyelesaian masalah",
                    "Database",
                    "Jaringan"
                ),
                answer = "Langkah penyelesaian masalah"
            ),

            Question(
                question = "Simbol flowchart untuk proses adalah?",
                options = listOf(
                    "Oval",
                    "Diamond",
                    "Rectangle",
                    "Arrow"
                ),
                answer = "Rectangle"
            ),

            Question(
                question = "Algoritma harus bersifat?",
                options = listOf(
                    "Acak",
                    "Tidak jelas",
                    "Logis",
                    "Rahasia"
                ),
                answer = "Logis"
            )

        )

        "Basis Data" -> listOf(

            Question(
                question = "Apa fungsi database?",
                options = listOf(
                    "Menggambar",
                    "Menyimpan data",
                    "Main game",
                    "Browsing"
                ),
                answer = "Menyimpan data"
            ),

            Question(
                question = "SQL digunakan untuk?",
                options = listOf(
                    "Desain",
                    "Edit video",
                    "Mengelola database",
                    "Bermain game"
                ),
                answer = "Mengelola database"
            ),

            Question(
                question = "Perintah untuk menampilkan data?",
                options = listOf(
                    "DELETE",
                    "UPDATE",
                    "SELECT",
                    "DROP"
                ),
                answer = "SELECT"
            )

        )

        else -> listOf(

            Question(
                question = "Apa fungsi router?",
                options = listOf(
                    "Menyimpan data",
                    "Menghubungkan jaringan",
                    "Membuat tabel",
                    "Menggambar"
                ),
                answer = "Menghubungkan jaringan"
            ),

            Question(
                question = "LAN adalah?",
                options = listOf(
                    "Jaringan lokal",
                    "Internet",
                    "Database",
                    "Program"
                ),
                answer = "Jaringan lokal"
            ),

            Question(
                question = "Perangkat untuk koneksi internet?",
                options = listOf(
                    "Mouse",
                    "Keyboard",
                    "Modem",
                    "Printer"
                ),
                answer = "Modem"
            )

        )
    }

    var currentQuestion by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf("") }

    val scorePerQuestion = 100 / questions.size
    val question = questions[currentQuestion]

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
            text = materi,
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF334155)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(modifier = Modifier.padding(20.dp)) {

                Text(
                    text = "Soal ${currentQuestion + 1}",
                    color = Color.Cyan,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = question.question,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        question.options.forEach { option ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1E293B)
                )
            ) {

                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    RadioButton(
                        selected = selectedAnswer == option,
                        onClick = { selectedAnswer = option }
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = option,
                        color = Color.White,
                        fontSize = 17.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                if (selectedAnswer == question.answer) {
                    score += scorePerQuestion
                }

                if (currentQuestion < questions.size - 1) {
                    currentQuestion++
                    selectedAnswer = ""
                } else {
                    ScoreManager.addScore(score)
                    onFinishQuiz(score)
                }

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2563EB)
            )
        ) {

            Text(
                text = if (currentQuestion == questions.size - 1)
                    "Selesai"
                else
                    "Next",
                fontSize = 18.sp
            )
        }
    }
}