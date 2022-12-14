package com.example.lewords.utils

sealed class ResultResponse<out T> {
    data class Success<out T>(val data: T? = null) : ResultResponse<T>()
    data class Loading(val nothing: Nothing?=null) : ResultResponse<Nothing>()
    data class Error(val msg: String?) : ResultResponse<Nothing>()
}