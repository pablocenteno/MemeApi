package com.example.memeapi.response


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface APIService {

    @GET
    fun getMeme(@Url url:String): Call<MemeResponse>

    @GET
    fun dameMemes(@Url url:String): Call<List<MemeResponse>>
}