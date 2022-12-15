package com.example.lewords.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lewords.databinding.ActivityLoginBinding
import com.example.lewords.model.user.login.LoginResponse
import com.example.lewords.ui.MainActivity
import com.example.lewords.ui.registration.RegistrationActivity
import com.example.lewords.utils.ResultResponse
import com.example.lewords.utils.SessionManager


class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel : LoginViewModel
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.usernameLoginEditText.setText(SessionManager.getUserName(applicationContext))
        binding.passwordLoginEditText.setText(SessionManager.getPassword(applicationContext))
        loginViewModel.loginResult.observe(this){
            when(it){
                is ResultResponse.Loading -> {
                    binding.loginButton.visibility  =  View.GONE
                    binding.progressBarLogin.visibility  = View.VISIBLE
                }
                is ResultResponse.Error ->{
                    binding.loginButton.visibility  =  View.VISIBLE
                    binding.progressBarLogin.visibility  = View.GONE
                }
                is ResultResponse.Success ->{
                    processLogin(it.data)
                    navigateToMainActivity()
                }
                else -> {
                    binding.loginButton.visibility  =  View.VISIBLE
                    binding.progressBarLogin.visibility  = View.GONE
                }
            }
        }



        binding.loginButton.setOnClickListener{
            doLogin()
        }


        binding.NoAccountButton.setOnClickListener{
            val i = Intent(this,RegistrationActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    private fun navigateToMainActivity() {
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
        finish()
    }

    private fun processLogin(data: LoginResponse?) {
        data?.let {
            SessionManager.saveUserToken(this, it.token)
        }
    }

    private fun doLogin(){
        loginViewModel.loginUser(
            binding.usernameLoginEditText.text.toString(),
            binding.passwordLoginEditText.text.toString())
    }

}