package com.example.studyhub.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.studyhub.data.MaterialItem

@Composable
fun HomeScreen(
    onMaterialClick: (String) -> Unit,
    onHistoryClick: () -> Unit
) {

    val materials = listOf(
        MaterialItem(
            title = "Algoritma Dasar",
            description = "Belajar dasar algoritma dan logika pemrograman"
        ),
        MaterialItem(
            title = "Basis Data",
            description = "Mempelajari database dan SQL"
        ),
        MaterialItem(
            title = "Jaringan Komputer",
            description = "Dasar komunikasi dan jaringan komputer"
        )
    )

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
            .padding(16.dp)
    ) {

        Text(
            text = "StudyHub",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Pilih materi untuk mulai belajar",
            color = Color.LightGray,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(materials) { material ->
                MaterialCard(
                    material = material,
                    onClick = {
                        // Mengirim string judul ("Algoritma Dasar" / "Basis Data" / "Jaringan Komputer")
                        // ke AppNavigation untuk dibawa menuju DetailMateriScreen
                        onMaterialClick(material.title)
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onHistoryClick()
            },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF475569))
        ) {
            Text(
                text = "Lihat Riwayat Nilai",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun MaterialCard(
    material: MaterialItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF334155)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = material.title,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = material.description,
                color = Color.LightGray,
                fontSize = 15.sp
            )
        }
    }
}