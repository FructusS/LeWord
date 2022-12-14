package com.example.lewords.model.user.registration

import com.google.gson.annotations.SerializedName


data class RegistrationResponse(
    val email: String,
    @SerializedName("firstName")
    val firstname: String,
    val genderId: Int,
    val id: Int,
    @SerializedName("lastName")
    val lastname: String,
    @SerializedName("userName")
    val username: String
)