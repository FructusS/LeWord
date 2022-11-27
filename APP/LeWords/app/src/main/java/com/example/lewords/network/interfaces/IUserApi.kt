package com.example.lewords.network.interfaces

import android.os.Build
import com.example.lewords.model.user.login.LoginRequest
import com.example.lewords.model.user.login.LoginResponse
import com.example.lewords.model.user.registration.RegistrationRequest
import com.example.lewords.model.user.registration.RegistrationResponse
import com.example.lewords.model.word.Word
import com.example.lewords.network.ApiService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface IUserApi {
    @POST("/login")
   suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("Users/registration")
    suspend fun registration(@Body registrationRequest: RegistrationRequest) : Response<RegistrationResponse>


    companion object {
        fun getUserApi() : IUserApi? {
            return  ApiService.client?.create(IUserApi::class.java)
        }
    }
}