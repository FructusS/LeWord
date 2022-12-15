package com.example.lewords.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.lewords.R

object SessionManager {
    private const val USER_TOKEN = "USER_TOKEN"
    private const val USER_PASSWORD = "USER_PASSWORD"
    private const val USER_NAME = "USER_NAME"
    private const val COUNT_WORDS = "COUNT_WORDS"
    fun saveUserToken(context: Context,token : String){
        saveString(context, USER_TOKEN,token)
    }

    fun saveCountWords(context: Context,value: Int) { saveString(context, COUNT_WORDS,value.toString())}
    fun getCountWords(context: Context) = getString(context, COUNT_WORDS)?.toInt()
    fun getUserToken(context: Context) =   getString(context, USER_TOKEN)

    fun saveUserName(context: Context,value : String){
        saveString(context, USER_NAME,value)
    }

    fun getUserName(context: Context)
            =   getString(context, USER_NAME)

    fun savePassword(context: Context,token : String){
        saveString(context, USER_PASSWORD,token)
    }
    fun getPassword(context: Context)
            =   getString(context, USER_PASSWORD)

    private fun getString(context: Context, key: String) : String? {
        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return prefs.getString(key,null)
    }

    private fun saveString(context: Context, key: String, value: String) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun clearData(context: Context){
        val editor = context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
    }

}