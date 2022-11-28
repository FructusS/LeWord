package com.example.lewords.model.user.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("token")
    var token : String,
    @SerializedName("username")
    var username : String?

)