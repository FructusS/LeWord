package com.example.lewords.model.user.registration


data class RegistrationResponse(
    val email: String,
    val firstname: String,
    val genderId: Int,
    val id: Int,
    val lastname: String,
    val username: String
)