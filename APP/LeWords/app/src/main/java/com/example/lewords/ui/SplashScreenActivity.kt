package com.example.lewords.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lewords.R
import com.example.lewords.ui.login.LoginActivity
import com.example.lewords.ui.registration.RegistrationActivity
import com.example.lewords.utils.SessionManager

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(!SessionManager.getUserToken(this).isNullOrEmpty()){
            val intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
            finish()
            return
        }
        if(SessionManager.getUserName(this) != null){
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
            return
        }
        if(SessionManager.getUserName(this) == null){
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
            finish()
            return
        }


    }
}