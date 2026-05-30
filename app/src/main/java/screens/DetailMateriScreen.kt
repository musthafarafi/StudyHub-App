package com.example.studyhub.screens // Sesuaikan package-nya (hapus .ui jika tadi kamu pilih Cara 1)

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailMateriScreen(
    materiName: String,
    onStartQuiz: () -> Unit,
    onBack: () -> Unit
) {
    // Data materi mendalam yang disesuaikan dengan string tombol HomeScreen
    val kontenMateri = when (materiName) {
        "Algoritma Dasar" -> """
            Algoritma Dasar merupakan fondasi utama dalam dunia pemrograman. Secara definisi, algoritma adalah urutan langkah-langkah logis dan sistematis yang disusun secara tertulis untuk menyelesaikan suatu masalah tertentu secara efisien.

            A. CIRI-CIRI ALGORITMA (Menurut Donald E. Knuth):
            1. Finiteness (Keterbatasan): Algoritma harus berhenti setelah mengerjakan sejumlah langkah terbatas.
            2. Definiteness (Kepastian): Setiap langkah harus didefinisikan dengan urutan yang tepat dan tidak ambigu (bermakna ganda).
            3. Input (Masukan): Algoritma memiliki nol atau lebih masukan yang diberikan sebelum algoritma dijalankan.
            4. Output (Keluaran): Algoritma harus memiliki satu atau lebih hasil keluaran sebagai solusi.
            5. Effectiveness (Efektivitas): Setiap langkah harus sangat sederhana sehingga dapat dikerjakan dalam waktu yang masuk akal.

            B. STRUKTUR DASAR ALGORITMA:
            • Runtunan (Sequence): Instruksi dieksekusi baris demi baris secara berurutan dari atas ke bawah.
            • Pemilihan/Percabangan (Selection): Eksekusi langkah tertentu berdasarkan pemenuhan suatu kondisi (Contoh: If-Else).
            • Pengulangan (Looping): Mengulang sekumpulan instruksi selama kondisi tertentu masih terpenuhi (Contoh: For, While).

            C. CARA PENULISAN:
            Biasanya dinyatakan dalam bentuk Flowchart (diagram alir menggunakan simbol geometris) atau Pseudocode (kode semu yang menyerupai bahasa pemrograman manusia).
        """.trimIndent()

        "Basis Data" -> """
            Database (Basis Data) adalah sekumpulan data atau informasi yang disimpan secara digital dan terorganisir di dalam sistem komputer. Basis data dikelola oleh perangkat lunak yang disebut DBMS (Database Management System).

            A. KOMPONEN UTAMA BASIS DATA RELASIONAL:
            1. Table (Tabel): Struktur dasar tempat menyimpan data yang terdiri dari baris dan kolom.
            2. Field / Column: Atribut spesifik dari data yang disimpan. Contoh: Field 'NIM', 'Nama', atau 'Email'.
            3. Record / Row: Satu baris data utuh yang saling berhubungan di dalam tabel.
            4. Primary Key: Sebuah field unik yang menjadi identitas utama penyusun tabel, nilainya tidak boleh sama dan tidak boleh kosong (Contoh: NIM mahasiswa).

            B. BAHASA QUERY (SQL - Structured Query Language):
            Untuk berinteraksi dengan database, kita menggunakan perintah SQL yang dibagi menjadi:
            • DDL (Data Definition Language): Untuk membuat atau mengubah struktur database. Contoh perintah: CREATE, ALTER, DROP.
            • DML (Data Manipulation Language): Untuk memanipulasi data di dalam tabel. Contoh perintah: INSERT (tambah), SELECT (cari/tampilkan), UPDATE (ubah), dan DELETE (hapus).

            C. MANFAAT UTAMA:
            Mencegah terjadinya redudansi (duplikasi) data, menjaga konsistensi data, memudahkan pencarian informasi dalam skala besar, serta menjamin keamanan data pengguna.
        """.trimIndent()

        "Jaringan Komputer" -> """
            Jaringan Komputer adalah sistem yang menghubungkan dua atau lebih perangkat komputer menggunakan media transmisi tertentu (kabel atau nirikabel) agar dapat saling berkomunikasi, bertukar data, dan berbagi sumber daya (seperti printer atau koneksi internet).

            A. JENIS JARINGAN BERDASARKAN GEOGRAFIS:
            1. LAN (Local Area Network): Jaringan skala kecil dan terbatas, seperti di dalam satu ruangan, rumah, atau gedung sekolah.
            2. MAN (Metropolitan Area Network): Jaringan yang menghubungkan beberapa area LAN dalam satu kota (jangkauan 10-50 km).
            3. WAN (Wide Area Network): Jaringan berskala sangat luas geografisnya, mencakup antar negara atau benua (Contoh terbesar: Internet).

            B. PERANGKAT KERAS JARINGAN (HARDWARE):
            • Router: Perangkat pintar yang berfungsi menghubungkan dua atau lebih jaringan berbeda dan mengatur rute pengiriman paket data.
            • Switch: Menghubungkan banyak perangkat dalam satu jaringan LAN lokal dan membagikan data ke target yang tepat.
            • Access Point: Perangkat untuk memancarkan sinyal internet nirkabel (Wi-Fi).

            C. PROTOKOL DAN IP ADDRESS:
            Agar komunikasi berjalan lancar, diperlukan aturan universal yang disebut Protokol (seperti TCP/IP dan HTTP). Selain itu, setiap perangkat wajib memiliki IP Address (Internet Protocol) yang berfungsi sebagai alamat identitas unik agar paket data tidak salah kirim.
        """.trimIndent()

        else -> "Materi tidak ditemukan."
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F172A), // Biru gelap (Sama seperti HomeScreen kamu)
                        Color(0xFF1E293B)  // Abu-abu gelap
                    )
                )
            )
            .padding(16.dp)
    ) {
        // --- Bagian Atas / Custom Top Bar ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBack,
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF334155))
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Kembali ke Home",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Detail Materi",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Konten Materi Utama (Bisa Di-scroll) ---
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF1E293B), shape = RoundedCornerShape(20.dp))
                .padding(20.dp)
        ) {
            Text(
                text = materiName,
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = kontenMateri,
                color = Color(0xFFCBD5E1), // Warna teks abu-abu terang supaya tidak silau
                fontSize = 15.sp,
                lineHeight = 24.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Tombol Mulai Kuis di Paling Bawah ---
        Button(
            onClick = onStartQuiz,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(bottom = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF475569)) // Menyamakan warna tombol riwayat nilai
        ) {
            Text(
                text = "Mulai Kuis Sekarang",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}