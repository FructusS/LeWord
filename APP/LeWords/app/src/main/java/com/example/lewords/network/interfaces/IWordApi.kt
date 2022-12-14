package com.example.lewords.network.interfaces

import com.example.lewords.network.ApiService
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface IWordApi {
    @Headers("Content-Type:application/json")
    @GET("Words/countword")
    suspend fun getWords(@Query("countWords")  countWord : Int){

    }

    companion object {
        fun getWordApi() : IWordApi? {
            return ApiService.client?.create(IWordApi::class.java)
        }
    }
}