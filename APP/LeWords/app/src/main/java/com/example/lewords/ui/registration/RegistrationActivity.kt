package com.example.lewords.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lewords.R
import com.example.lewords.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginRegistration = binding.loginRegistrationEditText
        val passwordRegistration = binding.passwordRegistrationEditText
        val passwordRegistrationConfirm = binding.passwordRegistrationConfirmEditText
    }
}