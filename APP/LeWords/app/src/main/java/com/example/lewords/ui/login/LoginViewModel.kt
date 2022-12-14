package com.example.lewords.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lewords.model.user.login.LoginRequest
import com.example.lewords.model.user.login.LoginResponse
import com.example.lewords.network.repository.UserRepository
import com.example.lewords.utils.ResultResponse
import kotlinx.coroutines.launch


class LoginViewModel(application: Application): AndroidViewModel(application){

    private val userRepository = UserRepository()
    val loginResult: MutableLiveData<ResultResponse<LoginResponse>> = MutableLiveData()
    fun loginUser(username : String,password : String) {

        loginResult.value = ResultResponse.Loading()
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest( password = password, username = username)
                val response = userRepository.loginUser(loginRequest = loginRequest)
                if (response?.code() == 200){
                    loginResult.value = ResultResponse.Success(response.body())

                }
                else{
                    loginResult.value = ResultResponse.Error(response?.message())

                }
            } catch (ex : Exception){
                loginResult.value = ResultResponse.Error(ex.message)
            }

        }


    }
}