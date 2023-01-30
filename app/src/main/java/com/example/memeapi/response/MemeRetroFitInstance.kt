package com.example.memeapi.response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MemeRetrofitInstance {
    val api: APIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://damemeapi.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}