package com.example.studyhub.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyhub.network.RetrofitInstance
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var loginSuccess = mutableStateOf(false)
    var loading = mutableStateOf(false)
    var errorMessage = mutableStateOf("")

    // buat nampung nama user dari API
    var usernameApi = mutableStateOf("")

    fun login() {

        viewModelScope.launch {

            loading.value = true
            errorMessage.value = ""

            try {

                val response =
                    RetrofitInstance.api.loginDummy()

                if (response.isSuccessful) {

                    val user = response.body()

                    usernameApi.value =
                        user?.firstName ?: "User"

                    Log.d(
                        "RETROFIT_TEST",
                        "Login berhasil: ${user?.firstName}"
                    )

                    loginSuccess.value = true

                } else {

                    errorMessage.value =
                        "Login gagal"

                }

            } catch (e: Exception) {

                errorMessage.value =
                    e.message ?: "Terjadi error"

                Log.e(
                    "RETROFIT_TEST",
                    "Error: ${e.message}"
                )
            }

            loading.value = false
        }
    }
}