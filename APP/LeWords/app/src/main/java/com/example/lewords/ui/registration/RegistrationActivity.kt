package com.example.lewords.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.lewords.R
import com.example.lewords.databinding.ActivityRegistrationBinding
import com.example.lewords.ui.login.LoginViewModel

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var registrationViewModel: RegistrationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registrationViewModel = ViewModelProvider(this,)[RegistrationViewModel::class.java]
        val loginRegistration = binding.loginRegistrationEditText
        val passwordRegistration = binding.passwordRegistrationEditText
        val passwordConfirmRegistration = binding.passwordConfirmRegistrationEditText
        val emailRegistration= binding.emailRegistrationEditText
        val registerButton= binding.registerButton


        loginRegistration.addTextChangedListener {

        }
        registerButton.setOnClickListener{

        }
    }
}