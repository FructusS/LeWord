package com.example.lewords.ui.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.lewords.databinding.ActivityLoginBinding


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
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("username","Anupam")
        editor.putLong("l",100L)
        editor.commit()

    }
}