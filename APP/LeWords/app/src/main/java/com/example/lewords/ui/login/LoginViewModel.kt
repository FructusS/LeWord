package com.example.lewords.ui.login

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lewords.model.user.login.LoginRequest
import com.example.lewords.model.user.login.LoginResponse
import com.example.lewords.network.UserRepository
import com.example.lewords.utils.Resource
import kotlinx.coroutines.launch


class LoginViewModel(application: Application): AndroidViewModel(application){
    var sharedpreferences: SharedPreferences =
        application.getSharedPreferences("preference_key", Context.MODE_PRIVATE)
    private val userRepository = UserRepository()
    private val loginResult: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    fun loginUser(username : String,password : String) {

        loginResult.value = Resource.Loading()
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest( password = password, username = username)
                val response = userRepository.loginUser(loginRequest = loginRequest)
                if (response?.code() == 200){
                    loginResult.value = Resource.Success(response.body())

                }
                else{
                    loginResult.value = Resource.Error(response?.message())

                }
            } catch (ex : Exception){
                loginResult.value = Resource.Error(ex.message)
            }

        }


    }
}