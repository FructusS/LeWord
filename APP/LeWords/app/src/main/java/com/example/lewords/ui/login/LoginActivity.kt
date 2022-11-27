package com.example.lewords.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.lewords.R
import com.example.lewords.databinding.ActivityLoginBinding
import com.example.lewords.model.user.registration.RegistrationRequest
import com.example.lewords.model.word.Word
import com.example.lewords.network.interfaces.IUserApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel : LoginViewModel
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this,)[LoginViewModel::class.java]

        val registerButton = binding.loginButton
        val passwordEditText = binding.passwordLoginEditText.text.toString()
        val loginEditText = binding.usernameLoginEditText.text.toString()
        registerButton.setOnClickListener{
            loginViewModel.loginUser(loginEditText,passwordEditText)

        }

    }
}