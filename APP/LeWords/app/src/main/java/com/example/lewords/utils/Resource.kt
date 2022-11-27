package com.example.lewords.utils

sealed class Resource<out T> {
    data class Success<out T>(val data: T? = null) : Resource<T>()
    data class Loading(val nothing: Nothing?=null) : Resource<Nothing>()
    data class Error(val msg: String?) : Resource<Nothing>()
}