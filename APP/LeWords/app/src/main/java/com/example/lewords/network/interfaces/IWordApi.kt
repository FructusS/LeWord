package com.example.lewords.network.interfaces

import com.example.lewords.model.word.Word
import com.example.lewords.network.ApiService
import retrofit2.Response


import retrofit2.http.GET
import retrofit2.http.Headers

import retrofit2.http.Query

interface IWordApi {
    @Headers("Content-Type:application/json")
    @GET("Words")
    suspend fun getWords(@Query("countWords")  countWord : Int) : Response<List<Word>>



    companion object {
        fun getWordApi() : IWordApi? {
            return ApiService.client?.create(IWordApi::class.java)
        }
    }
}