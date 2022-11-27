package com.example.lewords.network

import com.example.lewords.model.user.login.LoginRequest
import com.example.lewords.model.user.login.LoginResponse
import com.example.lewords.model.user.registration.RegistrationRequest
import com.example.lewords.model.user.registration.RegistrationResponse
import com.example.lewords.network.interfaces.IUserApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class UserRepository  {

   suspend fun loginUser(loginRequest: LoginRequest) : Response<LoginResponse>?{
       return IUserApi.getUserApi()?.loginUser(loginRequest = loginRequest)
   }
    suspend fun registrationUser(registrationRequest: RegistrationRequest) : Response<RegistrationResponse>?{


       return IUserApi.getUserApi()?.registration(registrationRequest = registrationRequest)
    }


}