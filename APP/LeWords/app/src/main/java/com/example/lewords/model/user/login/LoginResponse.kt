package com.example.lewords.model.user.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("access_token")
    var access_token : String,
    @SerializedName("username")
    var username : String?

)