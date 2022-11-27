package com.example.lewords.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.lewords.model.user.login.LoginRequest
import com.example.lewords.model.user.login.LoginResponse
import com.example.lewords.model.user.registration.RegistrationRequest
import com.example.lewords.model.user.registration.RegistrationResponse
import com.example.lewords.network.UserRepository
import com.example.lewords.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LoginViewModel() : ViewModel(){
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