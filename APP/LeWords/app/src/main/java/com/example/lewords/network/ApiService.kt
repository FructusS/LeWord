package com.example.lewords.network

import com.example.lewords.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiService {
    private val mGson: Gson = GsonBuilder().setLenient().create()
    private var mRetrofit: Retrofit? = null
    private var mHttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    private var mOkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(mHttpLoggingInterceptor)
        .build()

    val client : Retrofit?
    get() {
        if (mRetrofit == null){
            mRetrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build()
        }
        return mRetrofit
    }



}