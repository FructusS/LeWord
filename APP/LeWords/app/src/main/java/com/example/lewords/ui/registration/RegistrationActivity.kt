package com.example.lewords.ui.registration

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lewords.databinding.ActivityRegistrationBinding
import com.example.lewords.model.user.registration.RegistrationResponse
import com.example.lewords.ui.login.LoginActivity
import com.example.lewords.utils.ResultResponse
import com.example.lewords.utils.SessionManager

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var registrationViewModel: RegistrationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registrationViewModel = ViewModelProvider(this)[RegistrationViewModel::class.java]





    registrationViewModel.registrationResult.observe(this){
        when(it){
            is ResultResponse.Loading -> {
                binding.registerButton.visibility  =  View.GONE
                binding.progressBarRegistration.visibility  = View.VISIBLE
            }
            is ResultResponse.Error ->{
                binding.registerButton.visibility  =  View.VISIBLE
                binding.progressBarRegistration.visibility  = View.GONE
            }
            is ResultResponse.Success ->{
                processRegistration(it.data)
                navigateToLogin()
            }
            else ->{
                binding.registerButton.visibility  =  View.VISIBLE
                binding.progressBarRegistration.visibility  = View.GONE
            }


        }
    }
        binding.registerButton.setOnClickListener{
            doRegistration()
        }
        binding.NoAccountButton.setOnClickListener{
            val i = Intent(this,LoginActivity::class.java)
            startActivity(i)
            finish()
        }

    }

    private fun navigateToLogin() {
        val i = Intent(this,LoginActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        i.addFlags(FLAG_ACTIVITY_NO_HISTORY)

        startActivity(i)
        finish()
    }

    private fun processRegistration(data: RegistrationResponse?) {
        data?.let {
            SessionManager.saveUserName(this, it.username)
            SessionManager.savePassword(this, binding.passwordRegistrationEditText.text.toString())
        }
    }

    private fun doRegistration(){
        val loginRegistration = binding.loginRegistrationEditText.text.toString()
        val passwordRegistration = binding.passwordRegistrationEditText.text.toString()
        val emailRegistration= binding.emailRegistrationEditText.text.toString()
        registrationViewModel.registrationUser(username =  loginRegistration, password = passwordRegistration, email =  emailRegistration)
    }
}