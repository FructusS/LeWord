package com.example.lewords.ui.registration

import android.app.Application
import android.util.Patterns
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lewords.model.user.registration.RegistrationRequest
import com.example.lewords.model.user.registration.RegistrationResponse
import com.example.lewords.network.UserRepository
import com.example.lewords.utils.Resource
import kotlinx.coroutines.launch
import java.lang.Exception

class RegistrationViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository = UserRepository()
    private val registrationResult : MutableLiveData<Resource<RegistrationResponse>> = MutableLiveData()

    suspend fun registrationUser(username : String, password : String, email : String){
        registrationResult.value = Resource.Loading()
        viewModelScope.launch {
            try{
                val registrationRequest = RegistrationRequest(email = email, password = password, username = username)
                val response = userRepository.registrationUser(registrationRequest = registrationRequest)
                if (response?.code() == 200){
                    registrationResult.value = Resource.Success(response.body())
                }
                else{
                    registrationResult.value = Resource.Error(response?.message())
                }
            } catch (ex : Exception){
                registrationResult.value = Resource.Error(ex.message)
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
    fun registrationDataChanged(username: String , password: String , confirmPassword : String,email : String){
        if(!isPasswordValid(password,confirmPassword)){

        }else if(!isEmailValid(email)){

        } else{

        }

    }
}