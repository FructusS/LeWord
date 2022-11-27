package com.example.lewords.network

import com.example.lewords.BuildConfig
import com.example.lewords.model.UnsafeOkHttpClient
import com.example.lewords.network.interfaces.IUserApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


object ApiService {
    var mRetrofit: Retrofit? = null
    var mHttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    var mOkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(mHttpLoggingInterceptor)
        .build()

    val client : Retrofit?
    get() {
        if (mRetrofit == null){
            mRetrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return mRetrofit
    }



}