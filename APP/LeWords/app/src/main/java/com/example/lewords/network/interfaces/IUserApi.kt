package com.example.lewords.network.interfaces

import com.example.lewords.model.user.login.LoginRequest
import com.example.lewords.model.user.login.LoginResponse
import com.example.lewords.model.user.registration.RegistrationRequest
import com.example.lewords.model.user.registration.RegistrationResponse
import com.example.lewords.network.ApiService
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface IUserApi {
    @Headers("Content-Type:application/json")
    @POST("Users/login")
   suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>
    @Headers("Content-Type:application/json")
    @POST("Users/registration")
    suspend fun registration(@Body registrationRequest: RegistrationRequest) : Response<RegistrationResponse>


    companion object {
        fun getUserApi() : IUserApi? {
            return  ApiService.client?.create(IUserApi::class.java)
        }
    }
}