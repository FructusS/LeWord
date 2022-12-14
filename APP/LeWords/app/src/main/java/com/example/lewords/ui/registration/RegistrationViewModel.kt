package com.example.lewords.ui.registration

import android.app.Application
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lewords.model.user.registration.RegistrationRequest
import com.example.lewords.model.user.registration.RegistrationResponse
import com.example.lewords.network.repository.UserRepository
import com.example.lewords.utils.ResultResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class RegistrationViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository = UserRepository()
    val registrationResult : MutableLiveData<ResultResponse<RegistrationResponse>> = MutableLiveData()

    fun registrationUser(username : String, password : String, email : String){
        registrationResult.value = ResultResponse.Loading()
        viewModelScope.launch {
            try{
                val registrationRequest = RegistrationRequest(email = email, password = password, username = username)
                val response = userRepository.registrationUser(registrationRequest = registrationRequest)
                if (response?.code() == 200){
                    Log.i("123","code 200" +  response.body().toString())
                    registrationResult.value = ResultResponse.Success(response.body())
                }
                else{
                    registrationResult.value = ResultResponse.Error(response?.message())
                    Log.i("123","else code 200" +   response?.message().toString())
                }
            } catch (ex : Exception){
                registrationResult.value = ResultResponse.Error(ex.message)
                Log.i("123","except" +  ex.message.toString())
            }

        }

    }
    private fun isPasswordValid(password: String , confirmPassword : String) : Boolean {
        return password != confirmPassword || password.length < 5
    }
    private fun isEmailValid(email : String) : Boolean {
        return  if(email.contains("@")){
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else{
            email.isNotBlank()
        }
    }
    fun registrationDataChanged(username: String , password: String , confirmPassword : String,email : String) : Boolean{
        if(!isPasswordValid(password,confirmPassword)){
            return false
        }else if(!isEmailValid(email)){
            return false
        }
        return true
    }
}