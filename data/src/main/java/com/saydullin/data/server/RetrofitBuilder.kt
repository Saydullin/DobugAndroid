package com.saydullin.data.server

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {

    companion object {

        fun get(baseUrl: String): Retrofit {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val original = chain.request()
                    val requestBuilder = original.newBuilder()
                        .header("Accept", "application/json")
                    val request = requestBuilder.build()
                    chain.proceed(request)
                }
                .callTimeout(30L, TimeUnit.SECONDS)
                .connectTimeout(30L, TimeUnit.SECONDS)
                .build()
            val gson = GsonBuilder()
                .serializeNulls()
                .create()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

    }

}