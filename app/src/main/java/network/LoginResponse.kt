package com.example.studyhub.model

data class LoginResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String
)